package com.sam.moh.repository;

import com.sam.moh.entity.ClinicPerson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClinicPersonRepository extends JpaRepository<ClinicPerson, Integer> {

    List<ClinicPerson> findAllByOrderByDateDesc();
    List<ClinicPerson> findAllByPersonId(Integer id);
}
