package com.wagawin.family.model.repository;

import com.wagawin.family.model.entity.ParentSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentSummaryRepository extends JpaRepository<ParentSummary, Long> {

}
