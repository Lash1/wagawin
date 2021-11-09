package com.wagawin.family.model.repository;

import com.wagawin.family.model.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends JpaRepository<House, Long> {

    House findByPersonId(Long personId);

    House findByPersonName(String personName);
}
