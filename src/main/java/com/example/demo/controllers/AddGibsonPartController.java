package com.example.demo.controllers;

import com.example.demo.domain.GuitarPart;
import com.example.demo.domain.GibsonGuitarPart;
import com.example.demo.service.GibsonPartService;
import com.example.demo.service.GibsonPartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 *
 *
 *
 *
 */
@Controller
public class AddGibsonPartController {
    @Autowired
    private ApplicationContext context;

    @GetMapping("/showFormAddOutPart")
    public String showFormAddOutsourcedPart(Model theModel){
        GuitarPart guitarPart =new GibsonGuitarPart();
        theModel.addAttribute("outsourcedpart", guitarPart);
        return "gibsonpartform";
    }

    @PostMapping("/showFormAddOutPart")
    public String submitForm(@Valid @ModelAttribute("outsourcedpart") GibsonGuitarPart part, BindingResult bindingResult, Model theModel){
        theModel.addAttribute("outsourcedpart",part);
        if(bindingResult.hasErrors() ){
            return "gibsonpartform";
        }
        else{
        GibsonPartService repo=context.getBean(GibsonPartServiceImpl.class);
        GibsonGuitarPart op=repo.findById((int)part.getId());
        if(op!=null)part.setProducts(op.getProducts());
            repo.save(part);
        return "confirmationaddpart";}
    }



}
