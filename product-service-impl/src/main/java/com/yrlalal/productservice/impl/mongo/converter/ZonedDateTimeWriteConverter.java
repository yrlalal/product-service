package com.yrlalal.productservice.impl.mongo.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@WritingConverter
public class ZonedDateTimeWriteConverter implements Converter<ZonedDateTime, String> {
    @Override
    public String convert(ZonedDateTime source) {
        return source.format(DateTimeFormatter.ISO_ZONED_DATE_TIME);
    }
}
