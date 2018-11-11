package com.sam.moh.repository;

import com.sam.moh.entity.ClinicPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicPersonRepository extends JpaRepository<ClinicPerson, Integer> {
}
