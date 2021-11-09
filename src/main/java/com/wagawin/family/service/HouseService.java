package com.wagawin.family.service;

import com.wagawin.family.model.repository.HouseRepository;
import com.wagawin.family.resource.dto.HouseDto;
import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HouseService {
    private final HouseRepository houseRepository;

    public HouseService(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    @Transactional(readOnly = true)
    public ResponseEntity<HouseDto> getByPersonName(String personName) throws NotFoundException {
        HouseDto house = houseRepository.findByPersonName(personName);
        if (house == null) {
            throw new NotFoundException("No house(s) found for person with name " + personName);
        }
        return ResponseEntity.ok(house);
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
