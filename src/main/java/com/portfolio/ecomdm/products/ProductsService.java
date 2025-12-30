package com.portfolio.ecomdm.products;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductsService {
    public  ProductsService() {}

    public List<Product> getMaleProducts() {
        ArrayList<Product> products = new ArrayList<>();
        Product p1 = new Product(
                1,
                "Product 1",
                "This is a great product.",
                19.99,
                "SKU12345"
        );
        products.add(p1);
        Product p2 = new Product(
                2,
                "Product 2",
                "Another awesome item.",
                29.99,
                "SKU67890"
        );
        products.add(p2);
        Product p3 = new Product(
                3,
                "Product 3",
                "You will love this!",
                39.99,
                "SKU11223"
        );
        products.add(p3);
        Product p4 = new Product(
                4,
                "Product 4",
                "Best seller of the year.",
                49.99,
                "SKU44556"
        );
        products.add(p4);

        return products;
    }

    public List<Product> getFemaleProducts() {
        ArrayList<Product> products = new ArrayList<>();
        Product p6 = new Product(
                6,
                "Product 6",
                "Great product.",
                190.99,
                "SKU12345200"
        );
        products.add(p6);
        Product p7 = new Product(
                7,
                "Product 7",
                "Awesome item.",
                290.99,
                "SKU11223500"
        );
        products.add(p7);
        Product p8 = new Product(
                8,
                "Product 8",
                "Love this!",
                390.99,
                "SKU11223700"
        );
        products.add(p8);
        Product p9 = new Product(
                9,
                "Product 9",
                "Best seller.",
                490.99,
                "SKU44556800"
        );
        products.add(p9);

        return products;
    }
}
