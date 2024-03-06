package com.yrlalal.productservice.impl.v1.service;

import com.yrlalal.productservice.api.v1.model.CreateProductRequest;
import com.yrlalal.productservice.api.v1.model.Product;

public interface ProductService {
    Product createProduct(CreateProductRequest productRequest);
    Product getProduct(String productId);
}
