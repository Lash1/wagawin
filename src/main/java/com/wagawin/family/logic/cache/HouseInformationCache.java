package com.wagawin.family.logic.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.RemovalListener;
import com.wagawin.family.resource.dto.HouseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class HouseInformationCache {

    private static final Logger LOGGER = LoggerFactory.getLogger(HouseInformationCache.class);
    private static final RemovalListener<String, HouseDto> LOGGING_AUTO_EVICTION_ONLY_REMOVAL_LISTENER
            = notification -> {
        if (notification.wasEvicted()) {
            LOGGER.info("Entry evicted from cache: {} - Reason: {}", notification, notification.getCause());
        }
    };
    private final Cache<String, HouseDto> houseByPersonNameCache;


    public HouseInformationCache(@Value("${houseByPersonCache.expirationInterval}") int expirationInterval) {
        this.houseByPersonNameCache = CacheBuilder.newBuilder()
                .concurrencyLevel(Runtime.getRuntime().availableProcessors())
                .expireAfterAccess(expirationInterval, TimeUnit.MINUTES)
                .removalListener(LOGGING_AUTO_EVICTION_ONLY_REMOVAL_LISTENER)
                .build();
    }

    public HouseDto getByPersonName(String personName) {
        HouseDto houseDto = houseByPersonNameCache.getIfPresent(personName);
        LOGGER.info("Entry {} was returned from cache by person name {}", houseDto, personName);
        return houseDto;
    }

    public void addToHouseByPersonCache(String personName, HouseDto houseDto) {
        if (personName != null && houseDto != null) {
            LOGGER.info("Adding entry {} for person name {} to cache", houseDto, personName);
            houseByPersonNameCache.put(personName, houseDto);
        }
    }


}
