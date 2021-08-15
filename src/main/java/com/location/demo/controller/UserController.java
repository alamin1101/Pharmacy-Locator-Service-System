package com.location.demo.controller;


import com.location.demo.entity.Pharmacy;
import com.location.demo.entity.User;
import com.location.demo.repository.PharmacyRepository;
import com.location.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PharmacyRepository pharmacyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping({"/", "", "/home"})
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/pharmacy-map")
    public String seePharmacyGoogleMap(Model model){

        List<Pharmacy> pharmacyList=pharmacyRepository.findAll();
        System.out.println(""+pharmacyList.size());
        model.addAttribute("list",pharmacyList);
        return "google-pharmacy-map";
    }


    @GetMapping("/login")
    public String login(Model model) {

        return "login";
    }


    @PostMapping("/login")
    public String login_success(Model model,Principal principal) {
        model.addAttribute("message", "login successfull.......");
        User user =userRepository.findByUsername(principal.getName());
        if(user.getRole().equals("ROLE_ADMIN"))
            return  "admin-home";
        else
        return "message";
    }



    @RequestMapping("/about")
    public String about() {
        return "about";
    }


    @GetMapping("/all-pharmacy-distance")
    public String pharmacyDistance(Model model) {

        model.addAttribute("list", pharmacyRepository.findAll());
        return "all-pharmacy-distance";
    }
    @GetMapping("/my-location")
    public String myLocation(Model model,Principal principal) {

        User user=userRepository.findByUsername(principal.getName());
        model.addAttribute("list",user);
        return "my-location";
    }

    @GetMapping({"/signup"})
    public String signup(Model model) {
        model.addAttribute("message", null);
        model.addAttribute("user", new User());
        return "signup-form";
    }




    @PostMapping("/signup-success")
    public String signSuccess(@Valid User user, Model model)
    {

        if(userRepository.countUsersByUsername(user.getUsername())==1) {
            model.addAttribute("message", "username already exist...");
            return "signup-form";
        }
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            model.addAttribute("message", "password not matched...");
            return "signup-form";
        }
        String pass = passwordEncoder.encode(user.getPassword());
        user.setPassword(pass);

        if(userRepository.findByRole().isEmpty()) {
            user.setRole("ROLE_ADMIN");
        }
        else {
            user.setRole("ROLE_USER");
        }
        userRepository.save(user);
        model.addAttribute("message","Successfully SignUp");
        return "message";
    }


    @RequestMapping("/logout")
    public String logout(@Valid User user)
    {
        return "login";
    }


    @RequestMapping("/profile")
    public String profile(Principal principal, Model model)
    {
        User user = userRepository.findById(principal.getName()).get();
        model.addAttribute("user_info", user);
        return "profile";
    }

    @RequestMapping("/profile/settings")
    public String profileSettings(Principal principal, Model model)
    {
        User user = userRepository.findById(principal.getName()).get();
        model.addAttribute("user", user);
        return "profile_settings";
    }

    @RequestMapping("/profile-update")
    public String profileUpdate(@Valid User user, Model model)
    {


        if (!user.getPassword().equals(user.getConfirmPassword())) {
            model.addAttribute("message", "password not matched...");
            return "profile_settings";
        }
        String pass = passwordEncoder.encode(user.getPassword());
        user.setPassword(pass);
        userRepository.save(user);
        if(user.getRole().equals("ROLE_ADMIN"))
            return "admin-home";
        else
            return "home";
    }


}