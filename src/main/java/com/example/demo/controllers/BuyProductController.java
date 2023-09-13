package com.example.demo.controllers;

import com.example.demo.domain.Product;
import com.example.demo.service.PartService;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class BuyProductController {
    @Autowired
    private ApplicationContext context;


    @GetMapping("/buyProduct")
    public String buyProduct(@Valid @RequestParam("productID") int id) {

        ProductService productService = context.getBean(ProductServiceImpl.class);
        Product product = productService.findById((id));
        if (product != null && product.getId() != 0 && product.getInv() > 0) {
            product.setInv(product.getInv() - 1);
            productService.save(product);
            return "success";

        } else {
            return "failure";
        }

    }

}
