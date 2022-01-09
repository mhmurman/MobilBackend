package com.mobilabackend.server.service;

import com.mobilabackend.server.DTO.ProductCategoryDTO;
import com.mobilabackend.server.DTO.ProductDTO;
import com.mobilabackend.server.repository.CategoryRepository;
import com.mobilabackend.server.repository.ProductRepository;
import com.mobilabackend.server.viewobjects.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public List<ProductCategoryDTO> getAllCategorys() {
        return null;
    }

    public List<ProductDTO> getAllProducts(){
        return productRepository.findAll();
    }
}
