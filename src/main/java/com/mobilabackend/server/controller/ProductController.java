package com.mobilabackend.server.controller;

import com.mobilabackend.server.service.ProductService;
import com.mobilabackend.server.viewobjects.StoredProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<StoredProduct>> getAllProducts(){
        return new ResponseEntity<List<StoredProduct>>(StoredProduct.fromDTO(productService.getAllProducts()), HttpStatus.OK);
    }
}
