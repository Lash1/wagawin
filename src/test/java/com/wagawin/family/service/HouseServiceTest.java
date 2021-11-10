package com.wagawin.family.service;

import com.wagawin.family.common.enums.HouseType;
import com.wagawin.family.logic.cache.HouseInformationCache;
import com.wagawin.family.model.repository.HouseRepository;
import com.wagawin.family.resource.dto.HouseDto;
import javassist.NotFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class HouseServiceTest {

    private static final String TEST_PERSON_NAME = "test";
    @Autowired
    private HouseService houseService;
    @Autowired
    private HouseInformationCache houseInformationCache;
    @MockBean
    private HouseRepository houseRepository;

    @Test
    void testEntrySavedInCache() throws NotFoundException {

        Mockito.when(houseRepository.findByPersonName(TEST_PERSON_NAME)).thenReturn(getTestHouseDto());

        assertNull(houseInformationCache.getByPersonName(TEST_PERSON_NAME));

        houseService.getByPersonName(TEST_PERSON_NAME);

        assertNotNull(houseInformationCache.getByPersonName(TEST_PERSON_NAME));

    }

    private HouseDto getTestHouseDto() {
        return new HouseDto("bla", "12345", HouseType.HOUSE);
    }
}
