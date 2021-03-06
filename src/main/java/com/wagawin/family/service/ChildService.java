package com.wagawin.family.service;

import com.wagawin.family.model.entity.Child;
import com.wagawin.family.model.entity.Daughter;
import com.wagawin.family.model.entity.Son;
import com.wagawin.family.model.repository.ChildRepository;
import com.wagawin.family.resource.dto.ChildDto;
import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ChildService {
    private final ChildRepository childRepository;

    public ChildService(ChildRepository childRepository) {
        this.childRepository = childRepository;
    }


    @Transactional(readOnly = true)
    public ResponseEntity<ChildDto> getChildInfoByName(String childName) throws NotFoundException {
        Child child = childRepository.findFirstByName(childName);
        if (child == null) {
            throw new NotFoundException("No child(s) found with name " + childName);
        }
        return ResponseEntity.ok(ChildDto.fromChild(child));
    }


    @Transactional(readOnly = true)
    public ResponseEntity<Map<String, String>> getChildColorByName(String childName) throws NotFoundException {
        Child child = childRepository.findFirstByName(childName);
        if (child == null) {
            throw new NotFoundException("No child(s) found with name " + childName);
        }
        return ResponseEntity.ok(getChildColorMap(child));
    }

    @Transactional(readOnly = true)
    public ResponseEntity<ChildDto> getChildInfoById(Long childId) throws NotFoundException {
        Optional<Child> child = childRepository.findById(childId);
        if (child.isEmpty()) {
            throw new NotFoundException("No child(s) found with id " + childId);
        }
        return ResponseEntity.ok(ChildDto.fromChild(child.get()));
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Map<String, String>> getChildColorById(Long childId) throws NotFoundException {
        Optional<Child> child = childRepository.findById(childId);
        if (child.isEmpty()) {
            throw new NotFoundException("No child(s) found with id " + childId);
        }
        return ResponseEntity.ok(getChildColorMap(child.get()));
    }

    private Map<String, String> getChildColorMap(Child child) {
        Map<String, String> colorMap = new HashMap<>();
        if (child instanceof Son) {
            colorMap.put("bicycleColor", ((Son) child).getBicycleColor());
        } else if (child instanceof Daughter) {
            colorMap.put("hairColor", ((Daughter) child).getHairColor());
        }
        return colorMap;
    }
}
