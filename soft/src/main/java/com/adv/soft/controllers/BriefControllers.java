package com.adv.soft.controllers;

import java.util.List;
import com.adv.soft.models.Brief;
import com.adv.soft.repositories.BriefRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//TODO: This is currently wired directly to the repository. Get it working and then abstract it correctly.

@Controller
public class BriefControllers {

    @Autowired
    private BriefRepository briefRepository;

    @GetMapping("/createbrief")
    public String createBriefForm(Model model){
        model.addAttribute("brief", new Brief());
        return "createbriefform";
    }

    //TODO: Change this so that it shows the brief you just created instead
    @PostMapping("/processcreatebrief")
    public String processcreatebrief(Brief brief){
        briefRepository.save(brief);
        return "briefs";
    }

    @GetMapping("/briefs")
    public String listBriefs(Model model) {
        List<Brief> listBriefs = briefRepository.findAll();
        model.addAttribute("listBriefs", listBriefs);

        return "briefs";
    }
    
}
