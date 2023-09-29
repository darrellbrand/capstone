package com.example.demo.controllers;

import com.example.demo.domain.FenderGuitarPart;
import com.example.demo.service.FenderPartService;
import com.example.demo.service.FenderPartServiceImpl;
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
 */
@Controller
public class AddFenderPartController {
    @Autowired
    private ApplicationContext context;

    @GetMapping("/showFormAddInPart")
    public String showFormAddInhousePart(Model theModel) {
        FenderGuitarPart inhousepart = new FenderGuitarPart();
        theModel.addAttribute("inhousepart", inhousepart);
        return "fenderpartform";
    }

    @PostMapping("/showFormAddInPart")
    public String submitForm(@Valid @ModelAttribute("inhousepart") FenderGuitarPart part, BindingResult theBindingResult, Model theModel) {
        theModel.addAttribute("inhousepart", part);
        if (theBindingResult.hasErrors() ) {
            return "fenderpartform";
        } else {
            FenderPartService repo = context.getBean(FenderPartServiceImpl.class);
            FenderGuitarPart ip = repo.findById((int) part.getId());
            if (ip != null) part.setProducts(ip.getProducts());
            repo.save(part);

            return "confirmationaddpart";
        }
    }

}
