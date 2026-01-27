package com.portfolio.ecomdm.products;

import com.portfolio.ecomdm.products.dto.ProductRequest;
import com.portfolio.ecomdm.products.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductsService {
    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .category(productRequest.category())
                .skuCode(productRequest.skuCode())
                .price(productRequest.price())
                .build();
        productRepository.save(product);
        return new ProductResponse(
                    product.getId(),
                    product.getName(),
                    product.getDescription(),
                    product.getCategory(),
                    product.getSkuCode(),
                    product.getPrice()
        );
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(product -> new ProductResponse(
                                        product.getId(),
                                        product.getName(),
                                        product.getDescription(),
                                        product.getCategory(),
                                        product.getSkuCode(),
                                        product.getPrice())
                )
                .toList();
    }

    public List<Product> getMaleProducts() {
        return productRepository.findByCategory("MALE");
    }

    public List<Product> getFemaleProducts() {
        return productRepository.findByCategory("FEMALE");
    }
}
