package com.yrlalal.productservice.impl.v1.controller;

import com.yrlalal.productservice.api.v1.api.ProductApi;
import com.yrlalal.productservice.api.v1.model.CreateProductRequest;
import com.yrlalal.productservice.api.v1.model.Product;
import com.yrlalal.productservice.impl.v1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;

@RestController
public class ProductController implements ProductApi {
    @Value("${app.product.cache.duration.seconds}")
    private String cacheDurationInSeconds;
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @Override
    public ResponseEntity<Product> createProduct(CreateProductRequest productRequest) {
        HttpHeaders httpHeaders = getHttpHeaders();
        return ResponseEntity.ok().headers(httpHeaders).body(productService.createProduct(productRequest));
    }

    @Override
    public ResponseEntity<Product> getProduct(String productId) {
        return ResponseEntity.ok().headers(getHttpHeaders()).body(productService.getProduct(productId));
    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setCacheControl(MessageFormat.format("max-age={0}, must-revalidate",
                cacheDurationInSeconds));
        return httpHeaders;
    }
}
