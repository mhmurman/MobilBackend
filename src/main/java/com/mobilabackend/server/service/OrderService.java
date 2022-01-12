package com.mobilabackend.server.service;

import com.mobilabackend.server.DTO.OrderDTO;
import com.mobilabackend.server.DTO.OrderedProductDTO;
import com.mobilabackend.server.model.Order;
import com.mobilabackend.server.model.OrderedProduct;
import com.mobilabackend.server.repository.OrderRepository;
import com.mobilabackend.server.repository.OrderedProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderedProductRepository orderedProductRepository;

    @Transactional
    public void addOrder(Order order) {
        OrderDTO orderDTO = new OrderDTO(order.getTable(), new ArrayList<OrderedProductDTO>(){{
            for (OrderedProduct o:
                    order.getProducts()) {
                OrderedProductDTO orderedProd = orderedProductRepository.save(new OrderedProductDTO(o.getName(), o.getQuantity()));
                add(orderedProd);
            }
        }});
        orderRepository.save(orderDTO);
    }

    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll();
    }

    @Transactional
    public void deleteOrder(long id) {
        orderRepository.deleteById(id);
    }
}
