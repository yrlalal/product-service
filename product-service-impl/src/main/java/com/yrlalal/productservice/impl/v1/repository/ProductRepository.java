package com.yrlalal.productservice.impl.v1.repository;

import com.yrlalal.productservice.impl.v1.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
