package com.epam.training.currencyConverter.service;

public interface ConverterService {

    String getResult(String input, String sourceCurrency, String targetCurrency);

    String getRate(String sourceCurrency, String targetCurrency);
}
