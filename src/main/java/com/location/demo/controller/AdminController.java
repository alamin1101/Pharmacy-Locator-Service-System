package com.location.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @RequestMapping("/find-location")
    public String home()
    {
        return "find-location";
    }


    @GetMapping("/add-pharmacy")
    public String addPharmacy()
    {
        return  "add-pharmacy";
    }

}
