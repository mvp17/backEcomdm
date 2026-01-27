package com.portfolio.ecomdm.products;

import com.portfolio.ecomdm.products.dto.ProductRequest;
import com.portfolio.ecomdm.products.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductsController {
    private final ProductsService productsService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest) {
        return productsService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return productsService.getAllProducts();
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
