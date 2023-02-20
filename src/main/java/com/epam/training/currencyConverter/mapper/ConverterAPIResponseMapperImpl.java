package com.epam.training.currencyConverter.mapper;

import com.epam.training.currencyConverter.model.ConverterAPIResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class ConverterAPIResponseMapperImpl implements ConverterAPIResponseMapper {

    public static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public ConverterAPIResponse convert(String responseBody) throws JsonProcessingException {
        return mapper.readValue(responseBody, ConverterAPIResponse.class);
    }
}
