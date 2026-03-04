package com.example.productservice.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String sku;

    @NotNull
    @Positive
    private BigDecimal priceUnit;

    @NotNull
    @PositiveOrZero
    private Integer quantity;

    private String imageUrl;

    @NotBlank
    private String categoryId;

    @NotBlank
    private String categoryTitle;
}