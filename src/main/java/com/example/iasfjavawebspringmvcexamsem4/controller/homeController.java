package com.example.iasfjavawebspringmvcexamsem4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class homeController {
    @GetMapping("/")
    public String home(ModelMap modelMap){
        String view = "index";
        return view;
    }

}
