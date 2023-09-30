package com.example.demo.controllers;

import com.example.demo.domain.Guitar;
import com.example.demo.domain.GuitarPart;
import com.example.demo.service.GuitarPartService;
import com.example.demo.service.GuitarService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 *
 *
 *
 *
 */

@Controller
public class MainScreenController {

    private GuitarPartService guitarPartService;
    private GuitarService guitarService;

    private List<GuitarPart> theGuitarParts;
    private List<Guitar> theGuitars;

    public MainScreenController(GuitarPartService guitarPartService, GuitarService guitarService){
        this.guitarPartService = guitarPartService;
        this.guitarService = guitarService;
    }
    @GetMapping("/mainscreen")
    public String listPartsandProducts(Model theModel, @Param("partkeyword") String partkeyword, @Param("productkeyword") String productkeyword){

        List<GuitarPart> guitarPartList = guitarPartService.listAll(partkeyword);
        theModel.addAttribute("guitarParts", guitarPartList);
        theModel.addAttribute("partkeyword",partkeyword);
        List<Guitar> guitarList = guitarService.listAll(productkeyword);
        theModel.addAttribute("guitars", guitarList);
        theModel.addAttribute("productkeyword",productkeyword);
        return "mainscreen";
    }
}
