package com.mobilabackend.server.service;

import com.mobilabackend.server.DTO.ImageDTO;
import com.mobilabackend.server.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.SQLException;

@Service
public class ImageService {
    @Autowired
    private ImageRepository repository;

    public byte[] getImage(int img) throws SQLException, IOException {
        return repository.findById(img).get().getImage().getBinaryStream().readAllBytes();
    }

    public int postImage(MultipartFile image) throws IOException, SQLException {
        return repository.save(new ImageDTO(new SerialBlob(image.getBytes()))).getId();
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
