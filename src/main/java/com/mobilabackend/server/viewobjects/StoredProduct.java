package com.mobilabackend.server.viewobjects;

import com.mobilabackend.server.DTO.ProductDTO;

import java.util.ArrayList;
import java.util.List;

public class StoredProduct {
    private String productName;
    private int productPrice;
    private String imgUrl;

    public StoredProduct(String productName, int productPrice, String imgUrl) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.imgUrl = imgUrl;
    }

    public static List<StoredProduct> fromDTO(List<ProductDTO> all) {
        return new ArrayList<>(){{
            for (ProductDTO p : all){
                add(new StoredProduct(p.getName(), p.getPrice(),"http://ec2-16-171-16-167.eu-north-1.compute.amazonaws.com:8080/image/" + p.getImgUrl()));
            }
        }};
    }

    public String getProductName() {
        return productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
