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

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MyUserDetailsService userDetails;

    @GetMapping("")
    public String viewHome() {
        return "login";
    }

    // CHANGE ALL OF THIS IN FINAL VERSION, JUST FOR TESTING PURPOSES

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "signup_form";
    }

    // Registers the user and exchanges with repository. Skips service layer.
    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(user);

        return "register_success";
    }

    // Fetches list of users from repository. Skips service layer. Fine unless data
    // is being manipulated.
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


    //TODO: Check me. This is the redirect to a custom login page.
    @Configuration
    public class MvcConfig implements WebMvcConfigurer {

        @Override
        public void addViewControllers(ViewControllerRegistry registry) {
            registry.addViewController("/login").setViewName("login");

        }

    }

}
