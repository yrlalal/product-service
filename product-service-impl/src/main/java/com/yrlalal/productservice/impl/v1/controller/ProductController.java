package com.yrlalal.productservice.impl.v1.controller;

import com.yrlalal.productservice.api.v1.api.ProductApi;
import com.yrlalal.productservice.api.v1.model.CreateProductRequest;
import com.yrlalal.productservice.api.v1.model.Product;
import com.yrlalal.productservice.impl.v1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController implements ProductApi {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @Override
    public ResponseEntity<Product> createProduct(CreateProductRequest productRequest) {
        return productService.createProduct(productRequest);
    }

    @Override
    public ResponseEntity<Product> getProduct(String productId, String inputEtag) {
        ResponseEntity<Product> product = productService.getProduct(productId);

        // TODO: Update logic to get ETAG first.
        // If ETAG values do not match, then retrieve the entire product.
        return product.getHeaders().getETag() != null && product.getHeaders().getETag().equals(inputEtag)
                ? ResponseEntity.status(HttpStatus.NOT_MODIFIED).build()
                : product;
    }
}
