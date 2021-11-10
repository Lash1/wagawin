package com.wagawin.family.service;

import com.wagawin.family.logic.cache.HouseInformationCache;
import com.wagawin.family.model.repository.HouseRepository;
import com.wagawin.family.resource.dto.HouseDto;
import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HouseService {
    private final HouseRepository houseRepository;
    private final HouseInformationCache houseInformationCache;

    public HouseService(HouseRepository houseRepository, HouseInformationCache houseInformationCache) {
        this.houseRepository = houseRepository;
        this.houseInformationCache = houseInformationCache;
    }

    @Transactional(readOnly = true)
    public ResponseEntity<HouseDto> getByPersonName(String personName) throws NotFoundException {
        return ResponseEntity.ok(getHouseFromCache(personName));
    }

    private HouseDto getHouseFromCache(String personName) throws NotFoundException {
        HouseDto cachedHouse = houseInformationCache.getByPersonName(personName);
        if (cachedHouse == null) {
            HouseDto house = houseRepository.findByPersonName(personName);
            if (house == null) {
                throw new NotFoundException("No house(s) found for person with name " + personName);
            }
            houseInformationCache.addToHouseByPersonCache(personName, house);
            return house;
        }
        return cachedHouse;
    }

    @Transactional(readOnly = true)
    public ResponseEntity<HouseDto> getByPersonId(Long personId) throws NotFoundException {
        HouseDto house = houseRepository.findByPersonId(personId);
        if (house == null) {
            throw new NotFoundException("No house(s) found for person with id " + personId);
        }
        return ResponseEntity.ok(house);
    }
}
