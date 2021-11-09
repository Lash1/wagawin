package com.wagawin.family.resource;

import com.wagawin.family.model.entity.Child;
import com.wagawin.family.resource.dto.ChildDto;
import com.wagawin.family.service.ChildService;
import javassist.NotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping(value = "/child")
public class ChildResource {

    private final ChildService childService;

    public ChildResource(ChildService childService) {
        this.childService = childService;
    }

    @GetMapping(value = "/info/by-child-name/{childName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ChildDto> getChildInfoByName(@PathVariable String childName) throws NotFoundException {
        return childService.getChildInfoByName(childName);
    }

    @GetMapping(value = "/info/by-child-id/{childId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ChildDto> getChildInfoById(@PathVariable Long childId) throws NotFoundException {
        return childService.getChildInfoById(childId);
    }

    @GetMapping(value = "/color/by-child-name/{childName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String,String>> getChildColorByName(@PathVariable String childName) throws NotFoundException {
        return childService.getChildColorByName(childName);
    }

    @GetMapping(value = "/color/by-child-id/{childId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String,String>> getChildColorById(@PathVariable Long childId) throws NotFoundException {
        return childService.getChildColorById(childId);
    }
}
