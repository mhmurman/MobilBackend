package com.mobilabackend.server.model;

import com.mobilabackend.server.DTO.OrderDTO;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int table;
    private ArrayList<OrderedProduct> products;
    private long orderId;

    public Order() {
    }

    public Order(int table, ArrayList<OrderedProduct> items, long orderId) {
        this.table = table;
        this.products = items;
        this.orderId = orderId;
    }

    public static ArrayList<Order> fromDTO(List<OrderDTO> allOrders) {
        return new ArrayList<>(){{
            for (var o : allOrders){
                add(new Order(o.getTableNumber(), OrderedProduct.fromDTO(o.getOrderedProducts()), o.getId()));
            }
        }};
    }

    public int getTable() {
        return table;
    }

    public ArrayList<OrderedProduct> getProducts() {
        return products;
    }

    public long getOrderId() {
        return orderId;
    }
}
