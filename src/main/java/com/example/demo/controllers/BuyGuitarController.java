package com.example.demo.controllers;

import com.example.demo.domain.Guitar;
import com.example.demo.service.GuitarService;
import com.example.demo.service.GuitarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class BuyGuitarController {
    @Autowired
    private ApplicationContext context;


    @GetMapping("/buyProduct")
    public String buyProduct(@Valid @RequestParam("productID") int id) {

        GuitarService guitarService = context.getBean(GuitarServiceImpl.class);
        Guitar guitar = guitarService.findById((id));
        if (guitar != null && guitar.getId() != 0 && guitar.getInv() > 0) {
            guitar.setInv(guitar.getInv() - 1);
            guitarService.save(guitar);
            return "success";

        } else {
            return "failure";
        }

    }

}
