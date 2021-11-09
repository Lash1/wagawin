package com.wagawin.family.resource;

import com.wagawin.family.service.ParentsSummaryService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/persons")
public class PersonResource {

    private final ParentsSummaryService parentsSummaryService;

    public PersonResource(ParentsSummaryService parentsSummaryService) {
        this.parentsSummaryService = parentsSummaryService;
    }

    @GetMapping(value = "/children", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<int[]> gerPersonsChildren() {
        return parentsSummaryService.gerPersonsChildren();
    }

}
