package com.yrlalal.productservice.impl.v1.controller;

import com.yrlalal.productservice.api.v1.api.ProductApi;
import com.yrlalal.productservice.api.v1.model.CreateProductRequest;
import com.yrlalal.productservice.api.v1.model.Product;
import com.yrlalal.productservice.impl.v1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController implements ProductApi {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @Override
    public Product createProduct(CreateProductRequest productRequest) {
        return productService.createProduct(productRequest);
    }

    @Override
    public Product getProduct(String productId) {
        return productService.getProduct(productId);
    }
}
