package com.adv.soft.controllers;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.persistence.Id;
import javax.validation.constraints.Email;

import com.adv.soft.models.Industry;
import com.adv.soft.models.User;
import com.adv.soft.repositories.UserRepository;
import com.adv.soft.services.MyUserDetailsService;
import com.adv.soft.services.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//TODO: Revise your controllers and eliminate abstract business logic to the service layer
//i.e rewire this to methods in the service layer rather than directly to repo

@Controller
public class UserControllers {

    //TODO: Add security context for user based dynamic urls.

    @Autowired
    private UserRepository userRepository;

    //TODO: This doesn't appear to be used/necessary. Cleanup.
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

        return "login";
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
        List<User> listUsers = userRepository.findAllStudents();
        model.addAttribute("listUsers", listUsers);
        return "students";
    }

    //Directs user to about template
    @GetMapping("/about")
    public String viewAbout() {
        return "about";
    }
    
    @GetMapping("/employers")
    public String listEmployers(Model model) {
        List<User> listUsers = userRepository.findAllEmployers();
        model.addAttribute("listUsers", listUsers);
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

    //This is the key
    // TODO: returns profile of loggedin user. Might be problematic with thymeleaf special chararacters
    /* @RequestMapping(value = "/profile{email}", method = RequestMethod.GET)
    @ResponseBody
    public User viewUserById(@PathVariable String email) {


        return "profile";
    } */

    /* @GetMapping("/profile")
    public String fetchProfile(Model model) {
      
        model.addAttribute("user", user);
        return "profile";
    } */

   
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
