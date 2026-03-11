package com.example.productservice.repository;

import com.example.productservice.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {

    private final DynamoDbTable<Product> productTable;

    public ProductRepository(
            DynamoDbEnhancedClient enhancedClient,
            @Value("${aws.dynamodb.tableName:BioStockEventsTable}") String tableName) {
        this.productTable = enhancedClient.table(tableName, TableSchema.fromBean(Product.class));
    }

    public Product save(Product product) {
        productTable.putItem(product);
        return product;
    }

    public Optional<Product> findById(String id) {
        Product product = productTable.getItem(Key.builder().partitionValue(id).build());
        return Optional.ofNullable(product);
    }

    public List<Product> findAll() {
        return productTable.scan().items().stream().collect(Collectors.toList());
    }

    public void deleteById(String id) {
        productTable.deleteItem(Key.builder().partitionValue(id).build());
    }
}