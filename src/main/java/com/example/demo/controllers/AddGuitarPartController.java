package com.example.demo.controllers;

import com.example.demo.domain.FenderGuitarPart;
import com.example.demo.domain.GibsonGuitarPart;
import com.example.demo.domain.GuitarPart;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 *
 *
 *
 *
 */
@Controller
public class AddGuitarPartController {
    @Autowired
    private ApplicationContext context;

    @GetMapping("/showPartFormForUpdate")
    public String showPartFormForUpdate(@RequestParam("partID") int theId,Model theModel){

        GuitarPartService repo=context.getBean(GuitarPartServiceImpl.class);
        GibsonPartService outsourcedrepo=context.getBean(GibsonPartServiceImpl.class);
        FenderPartService inhouserepo=context.getBean(FenderPartServiceImpl.class);

        boolean inhouse=true;
        List<GibsonGuitarPart> outsourcedParts=outsourcedrepo.findAll();
        for(GibsonGuitarPart outsourcedPart:outsourcedParts) {
            if(outsourcedPart.getId()==theId)inhouse=false;
        }
        String formtype;
        if(inhouse){
            FenderGuitarPart inhousePart=inhouserepo.findById(theId);
            theModel.addAttribute("inhousepart",inhousePart);
            formtype="fenderpartform";
        }
        else{
            GibsonGuitarPart outsourcedPart=outsourcedrepo.findById(theId);
            theModel.addAttribute("outsourcedpart",outsourcedPart);
            formtype="gibsonpartform";
        }
        return formtype;
    }

    @GetMapping("/deletepart")
    public String deletePart(@Valid @RequestParam("partID") int theId,  Model theModel){
        GuitarPartService repo = context.getBean(GuitarPartServiceImpl.class);
        GuitarPart guitarPart =repo.findById(theId);
        if(guitarPart.getProducts().isEmpty()){
            repo.deleteById(theId);
            return "confirmationdeletepart";
        }
        else{
            return "negativeerror";
        }
    }

}
