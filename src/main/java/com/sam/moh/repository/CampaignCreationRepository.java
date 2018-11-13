package com.sam.moh.repository;

import com.sam.moh.entity.CampaignCreation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignCreationRepository extends JpaRepository<CampaignCreation,Integer> {
}
