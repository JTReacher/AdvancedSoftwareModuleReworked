package com.adv.soft.controllers;

import java.util.List;

import com.adv.soft.models.User;
import com.adv.soft.repositories.UserRepository;
import com.adv.soft.services.MyUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//TODO: Revise your controllers and eliminate abstract business logic to the service layer
//i.e rewire this to methods in the service layer rather than directly to repo

@Controller
public class UserControllers {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MyUserDetailsService userDetails;

    // Directs user to custom login page as root domain
    @GetMapping("")
    public String viewHome() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registerform";
    }

    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(user);

        return "profile";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> listUsers = userRepository.findAll();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }

    // Fetches list of students from repository. Skips service layer.
    @GetMapping("/students")
    public String listStudents(Model model) {
        List<User> listStudents = userRepository.findAllStudents();
        model.addAttribute("listStudents", listStudents);

        return "students";
    }

    //Directs user to about template
    @GetMapping("/about")
    public String viewAbout() {
        return "about";
    }
    
    @GetMapping("/employers")
    public String listEmployers(Model model) {
        List<User> listEmployers = userRepository.findAllEmployers();
        model.addAttribute("listEmployers", listEmployers);

        return "employers";
    }



    //TODO: Allows the user to reset their password by contacting admin or something
    @GetMapping("/forgot")
    public String viewForgot() {
        return "forgot";
    }

    //TODO: Allows user to make changes to their profile
    //How do? 
    @GetMapping("/settings")
    public String viewSettings() {
        return "settings";
    }

    // TODO: returns profile of loggedin user
    @GetMapping("/profile")
    public String viewMyProfile() {
        return "profile";
    }

    //TODO: returns profile of selected user


   
    //This probably should be in config not in my controllers page
    //TODO: Check me. This is the redirect to a custom login page.
    @Configuration
    public class MvcConfig implements WebMvcConfigurer {

        @Override
        public void addViewControllers(ViewControllerRegistry registry) {
            registry.addViewController("/login").setViewName("login");

        }

    }

}
