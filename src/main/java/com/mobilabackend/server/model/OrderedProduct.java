package com.mobilabackend.server.model;

import com.mobilabackend.server.DTO.OrderedProductDTO;

import java.util.ArrayList;
import java.util.List;

public class OrderedProduct {
    private String name;
    private int quantity;

    public OrderedProduct(){

    }

    public OrderedProduct(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public static ArrayList<OrderedProduct> fromDTO(List<OrderedProductDTO> orderedProducts) {
        return new ArrayList<>(){{
            for (var o : orderedProducts){
                add(new OrderedProduct(o.getName(), o.getQuantity()));
            }
        }};
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
