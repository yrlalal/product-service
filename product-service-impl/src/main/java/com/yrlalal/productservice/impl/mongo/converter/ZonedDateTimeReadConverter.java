package com.yrlalal.productservice.impl.mongo.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@ReadingConverter
public class ZonedDateTimeReadConverter implements Converter<String, ZonedDateTime> {

    @Override
    public ZonedDateTime convert(String s) {
        return ZonedDateTime.parse(s, DateTimeFormatter.ISO_ZONED_DATE_TIME);
    }
}
