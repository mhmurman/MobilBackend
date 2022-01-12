package com.mobilabackend.server.controller;

import com.mobilabackend.server.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;

@RestController
public class ImageController {
    @Autowired
    private ImageService service;

    @RequestMapping(value = "/image/{img}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity getImage(@PathVariable("img") int img){
        try {
            return new ResponseEntity<ByteArrayResource>(new ByteArrayResource(service.getImage(img)), HttpStatus.OK);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
