package com.yrlalal.productservice.api.v1.model;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class Product extends CreateProductRequest {
    private String productId;
    private Instant created;
}
