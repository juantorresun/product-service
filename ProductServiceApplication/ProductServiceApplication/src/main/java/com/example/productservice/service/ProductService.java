package com.example.productservice.service;

import com.example.productservice.model.Product;
import com.example.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public Product create(Product product) {
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());
        product.setLikesCount(0);
        return repository.save(product);
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product update(String id, Product updatedProduct) {
        Product existing = findById(id);

        existing.setTitle(updatedProduct.getTitle());
        existing.setPriceUnit(updatedProduct.getPriceUnit());
        existing.setQuantity(updatedProduct.getQuantity());
        existing.setCategoryId(updatedProduct.getCategoryId());
        existing.setCategoryTitle(updatedProduct.getCategoryTitle());
        existing.setUpdatedAt(LocalDateTime.now());

        return repository.save(existing);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}