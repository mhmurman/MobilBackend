package com.mobilabackend.server.viewobjects;

import com.mobilabackend.server.DTO.ProductDTO;

import java.util.ArrayList;
import java.util.List;

public class StoredProduct {
    private String productName;
    private int productPrice;
    private int productImageID;

    public StoredProduct(String productName, int productPrice, int productImageID) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productImageID = productImageID;
    }

    public static List<StoredProduct> fromDTO(List<ProductDTO> all) {
        return new ArrayList<>(){{
            for (ProductDTO p : all){
                add(new StoredProduct(p.getName(), p.getPrice(), p.getImageDTO().getId()));
            }
        }};
    }

    public String getProductName() {
        return productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public int getProductImageID() {
        return productImageID;
    }
}
