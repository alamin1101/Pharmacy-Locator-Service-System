package com.location.demo.controller;


import com.location.demo.entity.Pharmacy;
import com.location.demo.entity.User;
import com.location.demo.repository.PharmacyRepository;
import com.location.demo.repository.UserRepository;
import netscape.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.text.ParseException;
import java.util.Collections;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PharmacyRepository pharmacyRepository;

    @RequestMapping({"/", "", "/home"})
    public String home(Model model) {
        return "home";
    }

    @GetMapping({"/login"})
    public String login(Model model) {
        return "login";
    }



    @PostMapping({"/login"})
    public String login_success(Model model) {
        model.addAttribute("message", "successfully login.......");
        return "message";
    }


    @GetMapping("/user-location")
    public String userLocation(Model model)
    {
        return "user-location";
    }




        @RequestMapping(value = "/search/api/getSearchResult/{id}")
        public String getSearchResultViaAjax(@PathVariable(value = "id") String id)
        {
            System.out.println("hello "+id);
            return "home";
        }




    @GetMapping("/temp")
    public String m(Model model)
    {
        List<Pharmacy> pharmacyList = pharmacyRepository.findAll();
        for (Pharmacy pharmacy : pharmacyList)
        {
            pharmacy.setDistance(24.00, 90.00, pharmacy);
            System.out.println("" + pharmacy.getDistance());

        }
        Collections.sort(pharmacyList);
        model.addAttribute("small",pharmacyList.get(0));
        pharmacyList.remove(0);
        model.addAttribute("list",pharmacyList);
       return "temp";

    }

    @RequestMapping("/about")
    public String about() {
        return "about";
    }


    @GetMapping("/nearestPharmacy")
    public String nearestPharmacy(Model model) {

        model.addAttribute("list", pharmacyRepository.findAll());
        return "nearest-pharmacy";
    }

    @GetMapping({"/signup"})
    public String signup(Model model) {
        model.addAttribute("message", null);
        model.addAttribute("user", new User());
        return "signup-form";
    }




//    @PostMapping("/signup-success")
//    public String signSuccess(@Valid User user, Model model)
//    {
//
//        if(userRepository.countUsersByUsername(user.getUsername())==1) {
//            model.addAttribute("message", "username already exist...");
//            return "signup-form";
//        }
//        if (!user.getPassword().equals(user.getConfirmPassword())) {
//            model.addAttribute("message", "password not matched...");
//            return "signup-form";
//        }
//        String pass = passwordEncoder.encode(user.getPassword());
//        user.setPassword(pass);
//
//        if(userRepository.findByRole().isEmpty()) {
//            user.setRole("ROLE_ADMIN");
//        }
//        else {
//            user.setRole("ROLE_USER");
//        }
//        userRepository.save(user);
//        model.addAttribute("message","Successfully SignUp");
//        return "message";
//    }


//    @RequestMapping("/logout")
//    public String logout(@Valid User user)
//    {
//        return "login";
//    }


//    @RequestMapping("/profile")
//    public String profile(Principal principal, Model model)
//    {
//        User user = userRepository.findById(principal.getName()).get();
//        model.addAttribute("user_info", user);
//        return "profile";
//    }

//    @RequestMapping("/profile/settings")
//    public String profileSettings(Principal principal, Model model)
//    {
//        User user = userRepository.findById(principal.getName()).get();
//        model.addAttribute("user", user);
//        return "profile_settings";
//    }
//
//    @RequestMapping("/profile-update")
//    public String profileUpdate(@Valid User user, Principal principal, Model model)
//    {
//        if (!user.getPassword().equals(user.getConfirmPassword())) {
//            return "profile_settings";
//        }
//        String pass = passwordEncoder.encode(user.getPassword());
//        user.setPassword(pass);
//        userRepository.save(user);
//        if(user.getRole().equals("ROLE_ADMIN"))
//            return "admin-home";
//        else
//            return "consumer-home";
//    }

}