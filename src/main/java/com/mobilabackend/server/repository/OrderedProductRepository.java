package com.mobilabackend.server.repository;

import com.mobilabackend.server.DTO.OrderedProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderedProductRepository extends JpaRepository<OrderedProductDTO, Integer> {

}