package com.adv.soft.interfaces;

import java.util.List;
import com.adv.soft.models.Brief;

public interface BriefService {
    //modifier type name paramaters
    public List<Brief> findBriefs();
    public List<Brief> findBriefsByCompanyId(long companyId);
    //TODO: create search by skill many to many
/*     public List<Brief> findBriefsBySkills(String skills);
 */    public List<Brief> findBriefsByIndustry(String industry);
/*     public Brief findById(Long id);
 */
}
