package com.yrlalal.productservice.api.v1.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateProductRequest {
    @NotBlank(message = "productName is required")
    private String productName;
    private String productDescription;
    private List<String> productTags;
}
