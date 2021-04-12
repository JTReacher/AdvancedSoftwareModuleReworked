package com.adv.soft.repositories;

import com.adv.soft.models.Brief;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BriefRepository extends JpaRepository<Brief, Long> {
    
    //TODO: Fetch all briefs by company id, many to one.
    @Query("SELECT b from Brief b WHERE b.companyId = id")
    public List<Brief> findBriefsByCompanyId(long id);


    //FILTER
    //TODO: More complex service layer logic needed to transform the skills list and fetch
    // all matching
    //This is many to many or one to many.
   /*  //TODO:Fetch all briefs with a specific skills requirement
    @Query("SELECT b from Brief WHERE b.skillsRequired = id")
    public List<Brief> findAllBriefsBySkill(long id); */

    //FILTER
    //TODO: Fetch all briefs with a specific industry
    //This is one to many, should be simple
    @Query("SELECT b from Brief b WHERE b.industry = industry")
    public List<Brief> findAllBriefsByIndustry(String industry);

    //ALSO REQUIRED, BUT SHOULD BE DEFAULT JPA REPO FUNCTIONS
    //Default JPA methods to call from service layer
    //Find by ID should be default JPA functionality
    //Find all should be default JPA functionality

}
