package br.com.alura.refl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class ObjectToJson {

    public String transform(Object object) {
        String result = null;

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        Map<String, Object> mapper = new HashMap<>();
        Class<?> classToBeTransformed = object.getClass();

        Arrays.stream(classToBeTransformed.getDeclaredFields()).toList().forEach(
                field -> {
                    field.setAccessible(true);
                    String key = field.getName();
                    Object value = null;
                    try {
                        value = field.get(object);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    mapper.put(key, value);
                });

        try {
            result = objectMapper.writeValueAsString(mapper);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}