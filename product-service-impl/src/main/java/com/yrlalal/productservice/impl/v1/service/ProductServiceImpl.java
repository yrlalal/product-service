package com.yrlalal.productservice.impl.v1.service;

import com.yrlalal.productservice.api.v1.model.CreateProductRequest;
import com.yrlalal.productservice.api.v1.model.Product;
import com.yrlalal.productservice.impl.v1.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productrepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productrepository = productRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public Product createProduct(CreateProductRequest productRequest) {
        com.yrlalal.productservice.impl.v1.entity.Product product = modelMapper.map(productRequest, com.yrlalal.productservice.impl.v1.entity.Product.class);
        product.setProductId(UUID.randomUUID().toString());
        product.setCreated(ZonedDateTime.now());
        com.yrlalal.productservice.impl.v1.entity.Product savedProduct = productrepository.save(product);
        return modelMapper.map(savedProduct, Product.class);
    }

    @Override
    public Product getProduct(String productId) {
        return null;
    }
}
