package com.portfolio.ecomdm.pdf;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product {

    private int id;
    private String title;
    private String description;
    private Double price;

    public Product(int id, String title, String description, Double price) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
    }
}
