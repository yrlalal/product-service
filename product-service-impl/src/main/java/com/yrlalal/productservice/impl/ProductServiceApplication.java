package com.yrlalal.productservice.impl;

import com.yrlalal.productservice.api.ProductServiceApiConfiguration;
import com.yrlalal.productservice.impl.mongo.MongoConfig;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackageClasses = { ProductServiceApplication.class,
													ProductServiceApiConfiguration.class,
													MongoConfig.class })
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
