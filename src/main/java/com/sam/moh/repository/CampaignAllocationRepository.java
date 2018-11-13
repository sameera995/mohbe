package com.sam.moh.repository;

import com.sam.moh.entity.CampaignAllocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignAllocationRepository extends JpaRepository<CampaignAllocation,Integer> {
}
