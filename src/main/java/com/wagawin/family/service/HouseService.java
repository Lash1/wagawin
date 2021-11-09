package com.wagawin.family.service;

import com.wagawin.family.model.entity.House;
import com.wagawin.family.model.repository.HouseRepository;
import com.wagawin.family.resource.dto.HouseDto;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HouseService {
    private static final Logger LOGGER = LoggerFactory.getLogger(HouseService.class);
    private final HouseRepository houseRepository;

    public HouseService(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    public ResponseEntity<HouseDto> getByPersonName(String personName) throws NotFoundException {
        House house = houseRepository.findByPersonName(personName);
        if (house == null) {
            throw new NotFoundException("No house(s) found for person with name " + personName);
        }
        return ResponseEntity.ok(HouseDto.fromHouse(house));
    }

    public ResponseEntity<HouseDto> getByPersonId(Long personId) throws NotFoundException {
        House house = houseRepository.findByPersonId(personId);
        if (house == null) {
            throw new NotFoundException("No house(s) found for person with id " + personId);
        }
        return ResponseEntity.ok(HouseDto.fromHouse(house));
    }
}
