package com.mobilabackend.server.repository;

import com.mobilabackend.server.DTO.ImageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<ImageDTO, Integer> {

}