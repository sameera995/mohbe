package com.sam.moh.service;

import com.sam.moh.entity.CampaignAllocation;
import com.sam.moh.repository.CampaignAllocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CampaignAllocationService {
    private CampaignAllocationRepository campaignAllocationRepository;

    @Autowired
    public CampaignAllocationService(CampaignAllocationRepository campaignAllocationRepository){
        this.campaignAllocationRepository = campaignAllocationRepository;
    }

    @Transactional
    public Iterable<CampaignAllocation> findAll(){
        return campaignAllocationRepository.findAll(sortByIdDesc());
    }
    public Sort sortByIdDesc() {
        return new Sort(Sort.Direction.DESC, "id");
    }


    @Transactional
    public Optional<CampaignAllocation> findById(Integer id){
        return campaignAllocationRepository.findById(id);
    }

    @Transactional
    public void save(@RequestBody CampaignAllocation campaignAllocation) { campaignAllocationRepository.save(campaignAllocation);
    }

    @Transactional
    public void update(CampaignAllocation campaignAllocation) {
        campaignAllocationRepository.save(campaignAllocation);
    }

    @Transactional
    public List<CampaignAllocation> search(CampaignAllocation campaignAllocation) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<CampaignAllocation> example = Example.of(campaignAllocation, matcher);
        return campaignAllocationRepository.findAll(example);
    }
}
