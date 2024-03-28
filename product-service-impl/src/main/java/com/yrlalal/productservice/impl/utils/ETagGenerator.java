package com.yrlalal.productservice.impl.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ETagGenerator {
    private final ObjectMapper objectMapper;

    @Autowired
    public ETagGenerator(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
    public String calculateMD5ETag(Object inputObject) {
        try {
            String stringValue = objectMapper.writeValueAsString(inputObject);
            return calculateMD5ETag(stringValue);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to serialize object of type " + inputObject.getClass(), e);
        }
    }
    public static String calculateMD5ETag(String inputString) {
        return calculateMD5ETag(inputString.getBytes());
    }
    public static String calculateMD5ETag(byte[] data) {
        // Calculate the MD5 hash of the data
        byte[] md5Hash = DigestUtils.md5(data);

        // Convert the MD5 hash bytes to hexadecimal string
        String md5Hex = DigestUtils.md5Hex(md5Hash);

        // Enclose the MD5 hash in double quotes as required by ETag format
        return "\"" + md5Hex + "\"";
    }
}
