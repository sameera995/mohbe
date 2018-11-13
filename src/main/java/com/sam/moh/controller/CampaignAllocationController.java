package com.sam.moh.controller;

import com.sam.moh.entity.CampaignAllocation;
import com.sam.moh.service.CampaignAllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/campaignallocs")
@CrossOrigin("http://localhost:4200")
public class CampaignAllocationController {
    private CampaignAllocationService campaignAllocationService;

    @Autowired
    public CampaignAllocationController(CampaignAllocationService campaignAllocationService){
        this.campaignAllocationService = campaignAllocationService;}

    @GetMapping
    public Iterable<CampaignAllocation> findAll(){
        return campaignAllocationService.findAll();

    }

    @GetMapping("{id}")
    public Optional<CampaignAllocation> findById(@PathVariable Integer id) {
        return campaignAllocationService.findById(id);
    }

    @PutMapping
    public void save(@RequestBody CampaignAllocation campaignAllocation){
        campaignAllocationService.save(campaignAllocation);

    }

    @PutMapping("/search")
    public List<CampaignAllocation> search(@RequestBody CampaignAllocation campaignAllocation) {
        return campaignAllocationService.search(campaignAllocation);
    }
    
}
