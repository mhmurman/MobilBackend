package com.mobilabackend.server.viewobjects;

import com.mobilabackend.server.DTO.ProductDTO;

import java.util.ArrayList;
import java.util.List;

public class StoredProduct {
    private String productName;
    private int productPrice;

    public StoredProduct(String productName, int productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public static List<StoredProduct> fromDTO(List<ProductDTO> all) {
        return new ArrayList<>(){{
            for (ProductDTO p : all){
                add(new StoredProduct(p.getName(), p.getPrice()));
            }
        }};
    }

    public String getProductName() {
        return productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

}
