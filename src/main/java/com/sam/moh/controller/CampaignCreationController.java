package com.sam.moh.controller;

import com.sam.moh.entity.CampaignCreation;
import com.sam.moh.service.CampaignCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/campaigncreations")
@CrossOrigin("http://localhost:4200")
public class CampaignCreationController {

private CampaignCreationService campaignCreationService;

    @Autowired
    public CampaignCreationController(CampaignCreationService campaignCreationService){
        this.campaignCreationService = campaignCreationService;}

    @GetMapping
    public Iterable<CampaignCreation> findAll(){
        return campaignCreationService.findAll();

    }

    @GetMapping("{id}")
    public Optional<CampaignCreation> findById(@PathVariable Integer id) {
        return campaignCreationService.findById(id);
    }

    @PutMapping
    public void save(@RequestBody CampaignCreation campaignCreation){
        campaignCreationService.save(campaignCreation);

    }


//    public void update(Employee employee){
//       employeeService.update(employee);
//    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        campaignCreationService.delete(id);
    }

    @PutMapping("/search")
    public List<CampaignCreation> search(@RequestBody CampaignCreation campaignCreation) {
        return campaignCreationService.search(campaignCreation);
    }


}
