package com.mobilabackend.server.repository;

import com.mobilabackend.server.DTO.ProductCategoryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<ProductCategoryDTO, Integer> {

}
