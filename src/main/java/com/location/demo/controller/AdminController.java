package com.location.demo.controller;


import com.location.demo.entity.Pharmacy;
import com.location.demo.repository.PharmacyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class AdminController {

    @Autowired
    private PharmacyRepository pharmacyRepository;


    @RequestMapping("/show-all-pharmacy")
    public String showAllPharmacy(Model model)
    {
        model.addAttribute("list",pharmacyRepository.findAll());
        return "all-pharmacy";
    }

    @GetMapping("/update-pharmacy")
    public String updatePharmacy(@RequestParam String licenseNo, Model model){
        model.addAttribute("pharmacy", pharmacyRepository.findById(licenseNo).get());
        return "update-pharmacy";
    }


    @GetMapping("/see-pharmacy-google-map")
    public String seePharmacyGoogleMap(Model model){

        model.addAttribute("list",pharmacyRepository.findAll());
        return "pharmacy-in-google-map";
    }


    @PostMapping("/update-pharmacy")
    public String updatePharmacy(@Valid Pharmacy pharmacy)
    {

        pharmacyRepository.save(pharmacy);
        return "redirect:/show-all-pharmacy";
    }

    @RequestMapping("/delete-pharmacy")
    public String deletePharmacy(@RequestParam String licenseNo){
        pharmacyRepository.deleteById(licenseNo);
        return "redirect:/show-all-pharmacy";
    }

    @RequestMapping("/pharmacy-list")
    public String pharmacyList(Model model)
    {
        model.addAttribute("list",pharmacyRepository.findAll());
        return "pharmacy-list";
    }


    @GetMapping("/add-pharmacy")
    public String addPharmacy(Model model)
    {
        model.addAttribute("pharmacy",new Pharmacy());
        return  "add-pharmacy";
    }

    @PostMapping("/add-pharmacy")
    public String addPharmacy(@Valid Pharmacy pharmacy)
    {

        pharmacyRepository.save(pharmacy);
        return "add-pharmacy";
    }


}
