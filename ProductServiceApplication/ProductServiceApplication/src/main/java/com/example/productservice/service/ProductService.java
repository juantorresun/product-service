package com.example.productservice.service;

import com.example.productservice.dto.ProductRequest;
import com.example.productservice.model.Product;
import com.example.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public Product create(ProductRequest request) {
        Product product = new Product();
        product.setId(java.util.UUID.randomUUID().toString());
        product.setTitle(request.getTitle());
        product.setSku(request.getSku());
        product.setPriceUnit(request.getPriceUnit());
        product.setQuantity(request.getQuantity());
        product.setImageUrl(request.getImageUrl());
        product.setCategoryId(request.getCategoryId());
        product.setCategoryTitle(request.getCategoryTitle());
        product.setLikesCount(0);
        product.setCreatedAt(LocalDateTime.now().toString());
        product.setUpdatedAt(LocalDateTime.now().toString());

        return repository.save(product);
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
        HttpStatus.NOT_FOUND, "Product not found"));
    }

    public Product update(String id, ProductRequest request) {

        Product existing = findById(id);

        existing.setTitle(request.getTitle());
        existing.setSku(request.getSku());
        existing.setPriceUnit(request.getPriceUnit());
        existing.setQuantity(request.getQuantity());
        existing.setImageUrl(request.getImageUrl());
        existing.setCategoryId(request.getCategoryId());
        existing.setCategoryTitle(request.getCategoryTitle());
        existing.setUpdatedAt(LocalDateTime.now().toString());

        return repository.save(existing);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}