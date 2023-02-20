package com.epam.training.currencyConverter.service;

import com.epam.training.currencyConverter.mapper.ConverterAPIResponseMapper;
import com.epam.training.currencyConverter.model.ConverterAPIResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@AllArgsConstructor
public class CurrencyRateRetrieverImpl implements CurrencyRateRetriever {

    private ConverterAPIResponseMapper mapper;
    private ConverterAPICaller converterAPICaller;

    @Override
    public double getRate(String source, String target) {
        try {
            ConverterAPIResponse response = converterAPICaller.callConverterAPI(source);
            return response.getRates().get(target);
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }

}
