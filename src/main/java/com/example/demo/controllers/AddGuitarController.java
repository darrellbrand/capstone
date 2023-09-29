package com.example.demo.controllers;

import com.example.demo.domain.GuitarPart;
import com.example.demo.domain.Guitar;
import com.example.demo.service.GuitarPartService;
import com.example.demo.service.GuitarPartServiceImpl;
import com.example.demo.service.GuitarService;
import com.example.demo.service.GuitarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 *
 *
 */
@Controller
public class AddGuitarController {
    @Autowired
    private ApplicationContext context;
    private GuitarPartService guitarPartService;
    private List<GuitarPart> theGuitarParts;
    private static Guitar guitar1;
    private Guitar guitar;

    @GetMapping("/showFormAddProduct")
    public String showFormAddPart(Model theModel) {
        theModel.addAttribute("parts", guitarPartService.findAll());
        guitar = new Guitar();
        guitar1 = guitar;
        theModel.addAttribute("guitar", guitar);

        List<GuitarPart> availGuitarParts =new ArrayList<>();
        for(GuitarPart p: guitarPartService.findAll()){
            if(!guitar.getParts().contains(p)) availGuitarParts.add(p);
        }
        theModel.addAttribute("availparts", availGuitarParts);
        theModel.addAttribute("assparts", guitar.getParts());
        return "guitarform";
    }

    @PostMapping("/showFormAddProduct")
    public String submitForm(@Valid @ModelAttribute("guitar") Guitar guitar, BindingResult bindingResult, Model theModel) {
        theModel.addAttribute("guitar", guitar);

        if(bindingResult.hasErrors()){
            GuitarService guitarService = context.getBean(GuitarServiceImpl.class);
            Guitar guitar2 = guitarService.findById((int) guitar.getId());
            theModel.addAttribute("parts", guitarPartService.findAll());
            List<GuitarPart> availGuitarParts =new ArrayList<>();
            for(GuitarPart p: guitarPartService.findAll()){
                if(!guitar2.getParts().contains(p)) availGuitarParts.add(p);
            }
            theModel.addAttribute("availparts", availGuitarParts);
            theModel.addAttribute("assparts", guitar2.getParts());
            return "guitarform";
        }
 //       theModel.addAttribute("assparts", assparts);
 //       this.product=product;
//        product.getParts().addAll(assparts);
        else {
            GuitarService repo = context.getBean(GuitarServiceImpl.class);
            if(guitar.getId()!=0) {
                Guitar guitar2 = repo.findById((int) guitar.getId());
                GuitarPartService guitarPartService1 = context.getBean(GuitarPartServiceImpl.class);
                if(guitar.getInv()- guitar2.getInv()>0) {
                    for (GuitarPart p : guitar2.getParts()) {
                        int inv = p.getInv();
                        p.setInv(inv - (guitar.getInv() - guitar2.getInv()));
                        guitarPartService1.save(p);
                    }
                }
            }
            else{
                guitar.setInv(0);
            }
            repo.save(guitar);
            return "confirmationaddguitar";
        }
    }

    @GetMapping("/showProductFormForUpdate")
    public String showProductFormForUpdate(@RequestParam("productID") int theId, Model theModel) {
        theModel.addAttribute("parts", guitarPartService.findAll());
        GuitarService repo = context.getBean(GuitarServiceImpl.class);
        Guitar theGuitar = repo.findById(theId);
        guitar1 = theGuitar;
    //    this.product=product;
        //set the employ as a model attibute to prepopulate the form
        theModel.addAttribute("guitar", theGuitar);
        theModel.addAttribute("assparts", theGuitar.getParts());
        List<GuitarPart> availGuitarParts =new ArrayList<>();
        for(GuitarPart p: guitarPartService.findAll()){
            if(!theGuitar.getParts().contains(p)) availGuitarParts.add(p);
        }
        theModel.addAttribute("availparts", availGuitarParts);
        //send over to our form
        return "guitarform";
    }

    @GetMapping("/deleteproduct")
    public String deleteProduct(@RequestParam("productID") int theId, Model theModel) {
        GuitarService guitarService = context.getBean(GuitarServiceImpl.class);
        Guitar guitar2 = guitarService.findById(theId);
        for(GuitarPart guitarPart : guitar2.getParts()){
            guitarPart.getProducts().remove(guitar2);
            guitarPartService.save(guitarPart);
        }
        guitar2.getParts().removeAll(guitar2.getParts());
        guitarService.save(guitar2);
        guitarService.deleteById(theId);

        return "confirmationdeleteguitar";
    }

    public AddGuitarController(GuitarPartService guitarPartService) {
        this.guitarPartService = guitarPartService;
    }
// make the add and remove buttons work

    @GetMapping("/associatepart")
    public String associatePart(@Valid @RequestParam("partID") int theID, Model theModel){
    //    theModel.addAttribute("product", product);
    //    Product product1=new Product();
        if (guitar1.getName()==null) {
            return "saveproductscreen";
        }
        else{
        guitar1.getParts().add(guitarPartService.findById(theID));
        guitarPartService.findById(theID).getProducts().add(guitar1);
        GuitarService guitarService = context.getBean(GuitarServiceImpl.class);
        guitarService.save(guitar1);
        guitarPartService.save(guitarPartService.findById(theID));
        theModel.addAttribute("guitar", guitar1);
        theModel.addAttribute("assparts", guitar1.getParts());
        List<GuitarPart> availGuitarParts =new ArrayList<>();
        for(GuitarPart p: guitarPartService.findAll()){
            if(!guitar1.getParts().contains(p)) availGuitarParts.add(p);
        }
        theModel.addAttribute("availparts", availGuitarParts);
        return "guitarform";}
 //        return "confirmationassocpart";
    }
    @GetMapping("/removepart")
    public String removePart(@RequestParam("partID") int theID, Model theModel){
        theModel.addAttribute("guitar", guitar);
      //  Product product1=new Product();
        guitar1.getParts().remove(guitarPartService.findById(theID));
        guitarPartService.findById(theID).getProducts().remove(guitar1);
        GuitarService guitarService = context.getBean(GuitarServiceImpl.class);
        guitarService.save(guitar1);
        guitarPartService.save(guitarPartService.findById(theID));
        theModel.addAttribute("guitar", guitar1);
        theModel.addAttribute("assparts", guitar1.getParts());
        List<GuitarPart> availGuitarParts =new ArrayList<>();
        for(GuitarPart p: guitarPartService.findAll()){
            if(!guitar1.getParts().contains(p)) availGuitarParts.add(p);
        }
        theModel.addAttribute("availparts", availGuitarParts);
        return "guitarform";
    }
}
