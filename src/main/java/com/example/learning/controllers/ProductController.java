package com.example.learning.controllers;

import java.util.*;

import com.example.learning.entity.Product;
import com.example.learning.service.ProductService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;

import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public List<Product> list() {
        return service.listAll();
    }

}
