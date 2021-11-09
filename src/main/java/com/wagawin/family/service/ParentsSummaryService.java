package com.wagawin.family.service;

import com.wagawin.family.common.helper.ParentSummaryHelper;
import com.wagawin.family.model.entity.ParentSummary;
import com.wagawin.family.model.repository.ParentSummaryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ParentsSummaryService {

    private final ParentSummaryRepository parentSummaryRepository;

    public ParentsSummaryService(ParentSummaryRepository parentSummaryRepository) {
        this.parentSummaryRepository = parentSummaryRepository;
    }

    @Transactional(readOnly = true)
    public ResponseEntity<int[]> gerPersonsChildren() {
        List<ParentSummary> parentSummaryList = parentSummaryRepository.findAll();
        return ResponseEntity.ok(ParentSummaryHelper.toParentsSummaryArray(parentSummaryList));
    }
}
