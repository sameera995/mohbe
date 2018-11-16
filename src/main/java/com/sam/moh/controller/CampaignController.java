package com.sam.moh.controller;

import com.sam.moh.entity.Campaign;
import com.sam.moh.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/campaigns")
@CrossOrigin("http://localhost:4200")
public class CampaignController {
    private CampaignService campaignService;

    @Autowired
    public CampaignController(CampaignService campaignService){
        this.campaignService = campaignService;
    }

    @GetMapping
    public Iterable<Campaign> findAll(){
        return campaignService.findAll();
    }

    @GetMapping("{id}")
    public Optional<Campaign> findById(@PathVariable Integer id) {
        return campaignService.findById(id);
    }

    @PutMapping
    public void save(@RequestBody Campaign campaign){
        campaignService.save(campaign);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        campaignService.delete(id);
    }

}
