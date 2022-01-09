package com.mobilabackend.server.viewobjects;

import java.util.List;

public class ProductCathegory {
    private String catName;
    private List<StoredProduct> products;

    public ProductCathegory(String catName, List<StoredProduct> products) {
        this.catName = catName;
        this.products = products;
    }

    public String getCatName() {
        return catName;
    }

    public List<StoredProduct> getProducts() {
        return products;
    }
}
