package com.mobilabackend.server.DTO;

import javax.persistence.*;

@Entity
@Table(name = "ordered_product")
public class OrderedProductDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ordered_product_id", nullable = false)
    private Integer id;

    public OrderedProductDTO(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public OrderedProductDTO() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    private Integer quantity;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}