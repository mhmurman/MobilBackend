package com.mobilabackend.server.service;

import com.mobilabackend.server.DTO.ImageDTO;
import com.mobilabackend.server.DTO.ProductCategoryDTO;
import com.mobilabackend.server.DTO.ProductDTO;
import com.mobilabackend.server.repository.CategoryRepository;
import com.mobilabackend.server.repository.ProductRepository;
import com.mobilabackend.server.viewobjects.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public List<ProductDTO> getAllProducts(){
        return productRepository.findAll();
    }

    @Transactional
    public void addNewProduct(String name, int price) {
        ProductDTO p = new ProductDTO(name,price);
        productRepository.save(p);
    }

    private ProductCategoryDTO getOrCreateCategory(String category) {
        var c = categoryRepository.getProductCategoryDTOByCatName(category);
        if (c == null){
            c = categoryRepository.save(new ProductCategoryDTO(category));
        }
        return c;
    }

    @Transactional
    public void deleteEverything() {
        productRepository.deleteAll();
        categoryRepository.deleteAll();
    }
}
