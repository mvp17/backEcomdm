package com.portfolio.ecomdm.products;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product {

    private int id;
    private String name;
    private String description;
    private Double price;
    private String skuCode;

    public Product(int id, String name, String description, Double price, String skuCode) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.skuCode = skuCode;
    }
}
