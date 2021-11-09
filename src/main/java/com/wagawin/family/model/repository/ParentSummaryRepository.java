package com.wagawin.family.model.repository;

import com.wagawin.family.model.entity.ParentSummary;
import com.wagawin.family.model.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentSummaryRepository extends JpaRepository<ParentSummary, Long> {

}
