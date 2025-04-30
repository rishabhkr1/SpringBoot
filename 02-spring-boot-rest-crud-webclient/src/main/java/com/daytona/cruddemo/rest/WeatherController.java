package com.daytona.cruddemo.rest;

import com.daytona.cruddemo.entity.CustomResponse;
import com.daytona.cruddemo.service.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Map;

@Slf4j
@RestController
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public ResponseEntity<CustomResponse> getWeather(@RequestParam String city) {
        log.info("Received request for weather for city :: {}", city);
        return ResponseEntity.ok(new CustomResponse(weatherService.getWeatherByCity(city).getMain().getTemp()));
    }
}
