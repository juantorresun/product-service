package com.example.productservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document(collection = "products")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    private String id;

    private String title;
    private String sku;
    private BigDecimal priceUnit;
    private Integer quantity;
    private String imageUrl;

    // Categoría embebida (optimizado para lectura)
    private String categoryId;
    private String categoryTitle;

    private Integer likesCount;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}