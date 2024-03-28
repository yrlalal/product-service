package com.yrlalal.productservice.impl.v1.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Setter
@Document("products")
public class Product {
    @Id
    private String productId;
    private String etag;
    private ZonedDateTime created;
    private String productName;
    private String productDescription;
    private List<String> productTags;
}
