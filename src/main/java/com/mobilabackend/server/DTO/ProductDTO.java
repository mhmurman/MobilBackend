package com.mobilabackend.server.DTO;

import javax.persistence.*;

@Entity
@Table(name = "product_dto")
public class ProductDTO {
    public ProductDTO(){

    }
    public ProductDTO(String name, int price){
        this.name=name;
        this.price=price;
    }
    public ProductDTO(String name, int price, int img){
        this.name=name;
        this.price=price;
        this.imgUrl = img;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "img_url")
    private int imgUrl;

    public int getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(int imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}