package com.adv.soft.services;

import java.util.List;

import com.adv.soft.interfaces.BriefService;
import com.adv.soft.models.Brief;
import com.adv.soft.repositories.BriefRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class BriefServiceImpl implements BriefService {

    @Autowired
    private BriefRepository briefRepository;

    @Override
    public List<Brief> findBriefs() {
        
        //call repo to get all briefs
        //return all briefs
        List<Brief> briefs = briefRepository.findAll();
        return briefs;
    }

    @Override
    public List<Brief> findBriefsByCompanyId(long companyId) {
        List<Brief> briefs = briefRepository.findBriefsByCompanyId(companyId);
        return briefs;
    }

    

    @Override
    public List<Brief> findBriefsByIndustry(String industry) {
        List<Brief> briefs = briefRepository.findAllBriefsByIndustry(industry);
        return briefs;
    }

    // TODO:
    // findbyBriefId. Don't think I need a custom implementation of that. Should be
    // included.
    // Wait, but I do need to implement it in service layer.
    /* public Brief findById(Long id) {
        Brief brief = briefRepository.findById(id);
        return brief;
    } */

    // TODO: Search briefs by multiple skills
    // So, this needs to be many to many.
    // A list from a dropdown bubble in my template? so there will be a list of many
    // skills in my object.
    /*
     * @Override public List<Brief> findBriefsBySkills(String skills) {
     * 
     * List<Brief> briefs = briefRepository.findb; return briefs; }
     */

    
    
}
