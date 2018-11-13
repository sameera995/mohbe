package com.sam.moh.service;

import com.sam.moh.entity.CampaignCreation;
import com.sam.moh.repository.CampaignCreationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CampaignCreationService {
    private CampaignCreationRepository campaignCreationRepository;

    @Autowired
    public CampaignCreationService(CampaignCreationRepository campaignCreationRepository){
        this.campaignCreationRepository = campaignCreationRepository;
    }

    @Transactional
    public Iterable<CampaignCreation> findAll(){
        return campaignCreationRepository.findAll();
    }

    @Transactional
    public Optional<CampaignCreation> findById(Integer id){
        return campaignCreationRepository.findById(id);
    }

    @Transactional
    public void save(@RequestBody CampaignCreation campaignCreation) { campaignCreationRepository.save(campaignCreation);
    }

    @Transactional
    public void delete(Integer id){
        campaignCreationRepository.deleteById(id);
    }

    @Transactional
    public void update(CampaignCreation campaignCreation) {
        campaignCreationRepository.save(campaignCreation);
    }

    @Transactional
    public List<CampaignCreation> search(CampaignCreation campaignCreation) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<CampaignCreation> example = Example.of(campaignCreation, matcher);
        return campaignCreationRepository.findAll(example);
    }
}
