package com.yrlalal.productservice.impl.mongo;

import com.yrlalal.productservice.impl.mongo.converter.ZonedDateTimeReadConverter;
import com.yrlalal.productservice.impl.mongo.converter.ZonedDateTimeWriteConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.util.List;

@Configuration
public class MongoConfig {
    @Bean
    public MongoCustomConversions mongoCustomConversions() {
        return new MongoCustomConversions(List.of(new ZonedDateTimeReadConverter(), new ZonedDateTimeWriteConverter()));
    }
}

