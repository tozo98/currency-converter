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
        return String.format("%.4f", Double.valueOf(input) * rate);
    }

    @Override
    public String getRate(String sourceCurrency, String targetCurrency) {
        return String.format("%.4f", currencyRateRetriever.getRate(targetCurrency, sourceCurrency));
    }


}
