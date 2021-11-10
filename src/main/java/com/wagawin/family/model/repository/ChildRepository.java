package com.wagawin.family.model.repository;

import com.wagawin.family.model.entity.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildRepository extends JpaRepository<Child, Long> {

    Child findFirstByName(String name);
}
