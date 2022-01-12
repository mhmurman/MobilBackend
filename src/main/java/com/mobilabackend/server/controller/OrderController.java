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
    public ResponseEntity<String> addOrder(@RequestBody Order order){
        orderService.addOrder(order);
        return new ResponseEntity<String>("{\"message\":\"Happy ordering :)\"}", HttpStatus.OK);
    }

    @RequestMapping("/orders")
    public ResponseEntity<ArrayList<Order>> getOrders(){
        return new ResponseEntity<>(Order.fromDTO(orderService.getAllOrders()), HttpStatus.OK);
    }

    @DeleteMapping("/order/{id}")
    public void deleteOrder(@PathVariable("id") long id){
        orderService.deleteOrder(id);
    }
}
