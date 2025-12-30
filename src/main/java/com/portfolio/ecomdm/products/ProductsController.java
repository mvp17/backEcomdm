package com.portfolio.ecomdm.products;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductsController {
    private final ProductsService productsService;

    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/male")
    public List<Product> getMaleProducts() {
        return productsService.getMaleProducts();
    }

    @GetMapping("/female")
    public List<Product> getFemaleProducts() {
        return productsService.getFemaleProducts();
    }
}
