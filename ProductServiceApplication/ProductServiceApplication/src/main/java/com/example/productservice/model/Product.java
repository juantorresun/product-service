package com.example.productservice.model;

import lombok.*;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@DynamoDbBean
public class Product {

    private String id;

    @DynamoDbPartitionKey
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
    // Getters
    public String getTitle() { return title; }
    public String getSku() { return sku; }
    public BigDecimal getPriceUnit() { return priceUnit; }
    public Integer getQuantity() { return quantity; }
    public String getImageUrl() { return imageUrl; }
    public String getCategoryId() { return categoryId; }
    public String getCategoryTitle() { return categoryTitle; }
    public Integer getLikesCount() { return likesCount; }
    public String getCreatedAt() { return createdAt != null ? createdAt.toString() : null; }
    public String getUpdatedAt() { return updatedAt != null ? updatedAt.toString() : null; }

    // Setters
    public void setTitle(String title) { this.title = title; }
    public void setSku(String sku) { this.sku = sku; }
    public void setPriceUnit(BigDecimal priceUnit) { this.priceUnit = priceUnit; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public void setCategoryId(String categoryId) { this.categoryId = categoryId; }
    public void setCategoryTitle(String categoryTitle) { this.categoryTitle = categoryTitle; }
    public void setLikesCount(Integer likesCount) { this.likesCount = likesCount; }
    
    public void setCreatedAt(String createdAt) { 
        if(createdAt != null) this.createdAt = LocalDateTime.parse(createdAt); 
    }
    public void setUpdatedAt(String updatedAt) { 
        if(updatedAt != null) this.updatedAt = LocalDateTime.parse(updatedAt); 
    }
}