package com.yrlalal.productservice.api.v1.api;

import com.yrlalal.productservice.api.v1.model.CreateProductRequest;
import com.yrlalal.productservice.api.v1.model.Product;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/products")
@Validated
public interface ProductApi {
    @PostMapping
    Product createProduct(@Valid @RequestBody CreateProductRequest productRequest);

    @GetMapping("{productId}")
    Product getProduct(@PathVariable("productId") String productId);
}
