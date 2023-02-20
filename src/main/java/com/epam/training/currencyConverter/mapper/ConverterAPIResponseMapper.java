package com.epam.training.currencyConverter.mapper;

import com.epam.training.currencyConverter.model.ConverterAPIResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface ConverterAPIResponseMapper {

    ConverterAPIResponse convert(String responseBody) throws JsonProcessingException;
}
