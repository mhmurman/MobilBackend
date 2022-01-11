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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "price", nullable = false)
    private Integer price;

    /*
    @ManyToOne
    @JoinColumn(name = "product_category_id")
    private ProductCategoryDTO productCategory;

    public ProductCategoryDTO getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategoryDTO productCategory) {
        this.productCategory = productCategory;
    }

     */

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