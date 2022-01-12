package com.mobilabackend.server.controller;

import com.mobilabackend.server.model.Order;
import com.mobilabackend.server.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController()
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/order")
    public void addOrder(@RequestBody Order order){
        orderService.addOrder(order);
    }

    @RequestMapping("/orders")
    public ResponseEntity<ArrayList<Order>> getOrders(){
        return new ResponseEntity<>(Order.fromDTO(orderService.getAllOrders()), HttpStatus.OK);
    }

    @DeleteMapping("/order")
    public void deleteOrder(@RequestParam("id") long id){
        orderService.deleteOrder(id);
    }
}
