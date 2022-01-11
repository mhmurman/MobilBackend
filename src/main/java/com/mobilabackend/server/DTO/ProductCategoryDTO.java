package com.mobilabackend.server.DTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product_category")
public class ProductCategoryDTO {
    public ProductCategoryDTO(){

    }

    public ProductCategoryDTO(String catName){
        this.catName = catName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    /*
    @OneToMany(mappedBy = "productCategory", orphanRemoval = true)
    private List<ProductDTO> productDToes = new ArrayList<>();

    public List<ProductDTO> getProductDToes() {
        return productDToes;
    }

    public void setProductDToes(List<ProductDTO> productDToes) {
        this.productDToes = productDToes;
    }

     */
    @Column(name = "cat_name", nullable = false, unique = true)
    private String catName;

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}