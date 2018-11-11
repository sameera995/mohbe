package com.sam.moh.repository;

import com.sam.moh.entity.Area;
import com.sam.moh.entity.enums.AreaType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaRepository extends JpaRepository<Area,Integer> {

    List<Area> findAllByAreaType(AreaType areaType);
}
