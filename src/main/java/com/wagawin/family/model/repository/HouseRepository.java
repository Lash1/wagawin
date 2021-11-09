package com.wagawin.family.model.repository;

import com.wagawin.family.model.entity.House;
import com.wagawin.family.resource.dto.HouseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends JpaRepository<House, Long> {

    @Query("SELECT new com.wagawin.family.resource.dto.HouseDto(h.address, h.zipCode, h.type) FROM House h left outer join Person p on p.house = h.id WHERE p.id = :personId")
    HouseDto findByPersonId(Long personId);

    @Query("SELECT new com.wagawin.family.resource.dto.HouseDto(h.address, h.zipCode, h.type) FROM House h left outer join Person p on p.house = h.id WHERE p.name = :personName")
    HouseDto findByPersonName(String personName);
}
