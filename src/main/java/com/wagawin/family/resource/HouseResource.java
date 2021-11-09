package com.wagawin.family.resource;

import com.wagawin.family.resource.dto.HouseDto;
import com.wagawin.family.service.HouseService;
import javassist.NotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/house")
public class HouseResource {

    private final HouseService houseService;

    //TODO: test api processing time

    public HouseResource(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping(value = "/by-person-name/{personName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HouseDto> getByPersonName(@PathVariable String personName) throws NotFoundException {
        return houseService.getByPersonName(personName);
    }

    @GetMapping(value = "/by-person-id/{personId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HouseDto> getByPersonId(@PathVariable Long personId) throws NotFoundException {
        return houseService.getByPersonId(personId);
    }
}
