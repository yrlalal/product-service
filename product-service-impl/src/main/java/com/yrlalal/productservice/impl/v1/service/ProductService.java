package com.yrlalal.productservice.impl.v1.service;

import com.yrlalal.productservice.api.v1.model.CreateProductRequest;
import com.yrlalal.productservice.api.v1.model.Product;
import org.springframework.http.ResponseEntity;

public interface ProductService {
    ResponseEntity<Product> createProduct(CreateProductRequest productRequest);
    ResponseEntity<Product> getProduct(String productId);
}
