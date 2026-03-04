package com.example.productservice.controller;

import com.example.productservice.dto.ProductRequest;
import com.example.productservice.model.Product;
import com.example.productservice.service.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

@PostMapping
public Product create(@Valid @RequestBody ProductRequest request) {
    return service.create(request);
}

    @GetMapping
    public List<Product> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable String id) {
        return service.findById(id);
    }
    
@PutMapping("/{id}")
public Product update(@PathVariable String id,
                      @Valid @RequestBody ProductRequest request) {
    return service.update(id, request);
}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}