package com.mobilabackend.server.viewobjects;

import com.mobilabackend.server.DTO.ProductDTO;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    List<ProductCathegory> products;

    public static Warehouse fromDTO(List<ProductDTO> all) {
        /*
        return new Warehouse(new ArrayList<>(){{
            for (ProductDTO p : all){
                add(new StoredProduct(p.getName(), p.getPrice(), p.getImageDTO().getId()));
            }
        }});
         */
        return null;
    }

    public List<StoredProduct> getProducts() {
        return null;
    }
}
