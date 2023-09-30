package com.example.demo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {
    @GetMapping("/showAboutScreen")
    public String showAboutScreen()
    {
        return "about";
    }

}
