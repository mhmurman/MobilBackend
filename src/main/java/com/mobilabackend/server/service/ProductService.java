package com.mobilabackend.server.service;

import com.mobilabackend.server.DTO.ImageDTO;
import com.mobilabackend.server.DTO.ProductCategoryDTO;
import com.mobilabackend.server.DTO.ProductDTO;
import com.mobilabackend.server.repository.CategoryRepository;
import com.mobilabackend.server.repository.ProductRepository;
import com.mobilabackend.server.viewobjects.Warehouse;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ImageService imageService;

    public List<ProductDTO> getAllProducts(){
        return productRepository.findAll();
    }

    @Transactional
    public void addNewProduct(String name, int price, String url) throws IOException, SQLException {
        int image = imageService.postImage(fromUrl(url));
        ProductDTO p = new ProductDTO(name,price, image);
        productRepository.save(p);
    }

    private MultipartFile fromUrl(String url) throws IOException {
        BufferedImage image = ImageIO.read(new URL(url));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(image,"png",byteArrayOutputStream);

        String fileName = RandomString.make() + new Date().getTime() + ".png";
        MultipartFile multipartFile = new MockMultipartFile(fileName,
                fileName,"png" ,byteArrayOutputStream.toByteArray());
        byteArrayOutputStream.flush();
        byteArrayOutputStream.close();
        return multipartFile;
    }

    private ProductCategoryDTO getOrCreateCategory(String category) {
        var c = categoryRepository.getProductCategoryDTOByCatName(category);
        if (c == null){
            c = categoryRepository.save(new ProductCategoryDTO(category));
        }
        return c;
    }

    @Transactional
    public void deleteEverything() {
        productRepository.deleteAll();
        categoryRepository.deleteAll();
        imageService.deleteAll();
    }
}
