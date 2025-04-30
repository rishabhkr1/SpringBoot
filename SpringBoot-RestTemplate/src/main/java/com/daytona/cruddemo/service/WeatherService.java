package com.daytona.cruddemo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Slf4j
@Service
public class WeatherService {
   private final RestTemplate restTemplate;


    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    String apiKey = "38e90931dda570e2d059b0e4a3070db2";

    public Map<String, Object> getWeatherByCity(String city) {
        String url = UriComponentsBuilder.fromHttpUrl("https://api.openweathermap.org/data/2.5/weather")
                .queryParam("q", city)
                .queryParam("appid", apiKey)
                .queryParam("units", "metric")
                .toUriString();
        log.info("Request URL: {}", url);

        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
        return response.getBody();
    }
    }
