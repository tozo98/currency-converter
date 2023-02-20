package com.epam.training.currencyConverter.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConverterServiceImpl implements ConverterService {

    private CurrencyRateRetriever currencyRateRetriever;
    @Override
    public String getResult(String input, String sourceCurrency, String targetCurrency) {
        double rate = currencyRateRetriever.getRate(sourceCurrency, targetCurrency);
        return String.format("%.2f", Double.valueOf(input) * rate);
    }
}
