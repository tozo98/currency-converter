package com.epam.training.currencyConverter.service;

import com.epam.training.currencyConverter.mapper.ConverterAPIResponseMapper;
import com.epam.training.currencyConverter.model.ConverterAPIResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
@AllArgsConstructor
public class ConverterAPICaller {

    private static final String OPEN_ER_API_URI = "https://open.er-api.com/v6/latest/";

    private ConverterAPIResponseMapper mapper;
     public ConverterAPIResponse callConverterAPI(String source) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(OPEN_ER_API_URI + source)).GET().build();
        HttpClient client = HttpClient.newBuilder().build();
        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
        return mapper.convert(httpResponse.body());
    }
}
