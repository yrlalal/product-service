package com.yrlalal.productservice.api.v1.model;

import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
public class Product extends CreateProductRequest {
    private String productId;
    private ZonedDateTime created;
}
