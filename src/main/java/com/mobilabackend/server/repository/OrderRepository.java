package com.mobilabackend.server.repository;

import com.mobilabackend.server.DTO.OrderDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderDTO, Integer> {
    int deleteById(long id);
}