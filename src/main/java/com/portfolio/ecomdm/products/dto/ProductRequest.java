package com.portfolio.ecomdm.products.dto;

import java.math.BigDecimal;

public record ProductRequest(String id, String name, String description, String category,
                             String skuCode, BigDecimal price) { }
