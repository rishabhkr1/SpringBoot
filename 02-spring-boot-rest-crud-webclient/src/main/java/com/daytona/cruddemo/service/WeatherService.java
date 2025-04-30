package com.daytona.cruddemo.service;

import com.daytona.cruddemo.entity.WeatherResponseDTO;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WeatherService {

    private final WebClient weatherClient;

    public WeatherService(WebClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    public WeatherResponseDTO getWeatherByCity(String city) {
        String apiKey = "38e90931dda570e2d059b0e4a3070db2";

        return weatherClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/weather")
                        .queryParam("q", city)
                        .queryParam("appid", apiKey)
                        .build())
                .retrieve()
                //for error handling
                .onStatus(HttpStatusCode::is4xxClientError, response ->
                        response.bodyToMono(String.class) // Read response body as a String
                                .flatMap(errorBody -> {
                                    System.out.println("Client Error: " + errorBody);
                                    return Mono.error(new RuntimeException("Client error occurred: " + response.statusCode()));
                                })
                )
                .onStatus(HttpStatusCode::is5xxServerError,response ->
                        response.bodyToMono(String.class)
                                .flatMap(errorBody->{
                                    System.out.println("Server Error: "+errorBody);
                                    return Mono.error(new RuntimeException("Server error occurred: "+response.statusCode()));
                                })
                )
                .bodyToMono(WeatherResponseDTO.class)
                .block();
    }
}
