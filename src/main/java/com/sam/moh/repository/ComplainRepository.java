package com.sam.moh.repository;

import com.sam.moh.entity.Complain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplainRepository extends JpaRepository<Complain,Integer> {
}
