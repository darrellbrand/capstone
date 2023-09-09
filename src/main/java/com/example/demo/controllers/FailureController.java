package com.example.demo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FailureController {
    @GetMapping("/failure")
    public String showFailure() {
        return "failure";
    }

}
