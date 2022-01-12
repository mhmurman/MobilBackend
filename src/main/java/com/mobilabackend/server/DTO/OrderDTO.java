package com.mobilabackend.server.DTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class OrderDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orders_id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private Integer tableNumber;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="orders_id")
    private List<OrderedProductDTO> orderedProducts = new ArrayList<>();

    public OrderDTO(int table, ArrayList<OrderedProductDTO> orderedProductDTOS) {
        this.tableNumber = table;
        this.orderedProducts = orderedProductDTOS;
    }

    public OrderDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<OrderedProductDTO> getOrderedProducts() {
        return orderedProducts;
    }

    public void setOrderedProducts(List<OrderedProductDTO> orderedProductDToes) {
        this.orderedProducts = orderedProductDToes;
    }

    public Integer getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(Integer tableNumber) {
        this.tableNumber = tableNumber;
    }
}