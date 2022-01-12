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

    @PostMapping("/fill")
    public void fillDB(){
        productService.deleteEverything();
        try{
            //Till QM: bilden måste vara png.
            productService.addNewProduct("Carlsberg", 22, "https://media.discordapp.net/attachments/617332499042926603/930809826429263922/9k.png");
            productService.addNewProduct("Pabst Blue Ribbon", 19, "https://media.discordapp.net/attachments/617332499042926603/930809941986529380/unknown.png");
            productService.addNewProduct("Coca Cola", 10, "https://cdn.discordapp.com/attachments/617332499042926603/930904349129981952/9k.png");
            productService.addNewProduct("Sprite", 10, "https://cdn.discordapp.com/attachments/617332499042926603/930904394675920906/unknown.png");
            productService.addNewProduct("Fanta", 10, "https://cdn.discordapp.com/attachments/617332499042926603/930904441585033287/unknown.png");
            productService.addNewProduct("Sommersby: Äpple 0%", 15, "https://cdn.discordapp.com/attachments/617332499042926603/930904618525929532/unknown.png");
            productService.addNewProduct("Sommersby: Sparkling Spritz 4.5%", 25, "https://cdn.discordapp.com/attachments/617332499042926603/930904799896043520/unknown.png");
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
