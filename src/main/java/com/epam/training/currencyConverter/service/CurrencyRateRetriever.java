package com.epam.training.currencyConverter.service;

public interface CurrencyRateRetriever {
    double getRate(String source, String target);
}
