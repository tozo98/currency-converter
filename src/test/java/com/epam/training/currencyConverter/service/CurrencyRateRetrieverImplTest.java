package com.epam.training.currencyConverter.service;

import com.epam.training.currencyConverter.model.ConverterAPIResponse;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

@ExtendWith(MockitoExtension.class)
class CurrencyRateRetrieverImplTest {

    @Mock
    private ConverterAPICaller converterAPICaller;
    @InjectMocks
    private CurrencyRateRetrieverImpl underTest;
    @SneakyThrows
    @Test
    void testGetRateHappyPath() {
        double expected = 0.5;
        ConverterAPIResponse responseMock = new ConverterAPIResponse();
        responseMock.setRates(Collections.singletonMap("EUR", 0.5));
        Mockito.when(converterAPICaller.callConverterAPI(Mockito.anyString())).thenReturn(responseMock);
        double result = underTest.getRate("HUF", "EUR");
        Assertions.assertEquals(expected, result);
    }
}