package com.sam.moh.service;

import com.sam.moh.entity.Campaign;
import com.sam.moh.repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class CampaignService {
    private CampaignRepository campaignRepository;

    @Autowired
    public CampaignService(CampaignRepository campaignRepository){
        this.campaignRepository= campaignRepository;
    }

    @Transactional
    public Iterable<Campaign> findAll(){
        return campaignRepository.findAll();
    }

    @Transactional
    public Optional<Campaign> findById(Integer id){
        return campaignRepository.findById(id);
    }

    @Transactional
    public void save(@RequestBody Campaign clinic) { campaignRepository.save(clinic);
    }

    @Transactional
    public void delete(Integer id){
        campaignRepository.deleteById(id);
    }


}
