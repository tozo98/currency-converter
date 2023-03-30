package com.epam.training.currencyConverter.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ConverterServiceImplTest {

    @Mock
    private CurrencyRateRetriever currencyRateRetrieverMock;

    @InjectMocks
    private ConverterServiceImpl underTest;

    @Test
    void testGetResultMethodHappyPath() {
        String expected = "200.0000";
        Mockito.when(currencyRateRetrieverMock.getRate(Mockito.anyString(),Mockito.anyString())).thenReturn(0.5);
        String result = underTest.getResult("400", "HUF", "USD");
        assertEquals(expected, result);
    }

}