package com.location.demo.controller;

import com.location.demo.entity.Pharmacy;
import com.location.demo.repository.PharmacyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.List;

@Controller
public class UserLocation {


    @Autowired
    private PharmacyRepository pharmacyRepository;


    @GetMapping("/nearest-pharmacy")
    public String nearestPharmacy(Model model)
    {
        model.addAttribute("list",pharmacyRepository.findAll());
        return "nearest-pharmacy1";
    }


//    @PostMapping("/nearest-pharmacy")
//    public String nearestPharmacy(Model model,@RequestParam double latitude, @RequestParam double longitude) {
//        List<Pharmacy> pharmacyList = pharmacyRepository.findAll();
//        for (Pharmacy pharmacy : pharmacyList)
//        {
//            pharmacy.setDistance(latitude, longitude, pharmacy);
//            System.out.println("" + pharmacy.getDistance());
//
//        }
//        Collections.sort(pharmacyList);
//        model.addAttribute("small",pharmacyList.get(0));
//        pharmacyList.remove(0);
//        model.addAttribute("list",pharmacyList);
//        return "redirect:/home";
//
//    }
//
//
//
//    @GetMapping("/temp")
//    public String m(Model model)
//    {
//        List<Pharmacy> pharmacyList = pharmacyRepository.findAll();
//        for (Pharmacy pharmacy : pharmacyList)
//        {
//            pharmacy.setDistance(24.00, 90.00, pharmacy);
//            System.out.println("" + pharmacy.getDistance());
//
//        }
//        Collections.sort(pharmacyList);
//        model.addAttribute("small",pharmacyList.get(0));
//        pharmacyList.remove(0);
//        model.addAttribute("list",pharmacyList);
//        return "temp";
//
//    }
//
//
//
//    @GetMapping("/geolocation")
//    public String s()
//    {
//        return  "geolocation";
//
//    }
}
