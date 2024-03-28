package com.yrlalal.productservice.impl.v1.service;

import com.yrlalal.productservice.api.v1.model.CreateProductRequest;
import com.yrlalal.productservice.api.v1.model.Product;
import com.yrlalal.productservice.impl.utils.ETagGenerator;
import com.yrlalal.productservice.impl.v1.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    @Value("${app.product.cache.duration.seconds}")
    private String cacheDurationInSeconds;
    private final ProductRepository productrepository;
    private final ModelMapper modelMapper;
    private final ETagGenerator eTagGenerator;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, ETagGenerator eTagGenerator) {
        this.productrepository = productRepository;
        this.modelMapper = modelMapper;
        this.eTagGenerator = eTagGenerator;
    }
    @Override
    public ResponseEntity<Product> createProduct(CreateProductRequest productRequest) {
        com.yrlalal.productservice.impl.v1.entity.Product product = modelMapper.map(productRequest, com.yrlalal.productservice.impl.v1.entity.Product.class);
        product.setProductId(UUID.randomUUID().toString());
        product.setCreated(ZonedDateTime.now());
        product.setEtag(eTagGenerator.calculateMD5ETag(product));
        com.yrlalal.productservice.impl.v1.entity.Product savedProduct = productrepository.save(product);
        return getProduct(savedProduct);
    }

    @Override
    public ResponseEntity<Product> getProduct(String productId) {
        Optional<com.yrlalal.productservice.impl.v1.entity.Product> optionalProduct = productrepository.findById(productId);
        if (optionalProduct.isEmpty()) {
            throw new RuntimeException(MessageFormat.format("Product {0} not found", productId));
        }
        return getProduct(optionalProduct.get());
    }

    private ResponseEntity<Product> getProduct(com.yrlalal.productservice.impl.v1.entity.Product product) {
        return ResponseEntity.ok().headers(getHttpHeaders(product.getEtag())).body(modelMapper.map(product, Product.class));
    }

    private HttpHeaders getHttpHeaders(String etag) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setCacheControl(MessageFormat.format("max-age={0}, must-revalidate",
                cacheDurationInSeconds));
        httpHeaders.setETag(etag);
        return httpHeaders;
    }
}
