package com.rapidtech.restapi.controller;

import com.rapidtech.restapi.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

//
@RestController
@RequestMapping("/products")
public class ProductController {
    @GetMapping//ini targetnya method
    public List<Product> get(){
        return Arrays.asList(
                new Product(1,"Kopi",5000.4),
                new Product(2,"Kopi 2",6000.4),
                new Product(3,"Kopi 3",3000.4)
        );
    }
}
