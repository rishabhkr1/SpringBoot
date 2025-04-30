package com.daytona.cruddemo.config;

import io.netty.handler.logging.LogLevel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.transport.logging.AdvancedByteBufFormat;

@Configuration
public class WebClientConfig {

    @Bean("weatherClient")
    public WebClient webClient() {
        HttpClient httpClient = HttpClient
                .create()
                .wiretap("weather_app",
                        LogLevel.INFO, AdvancedByteBufFormat.TEXTUAL);
        return WebClient
                .builder()
                .baseUrl("https://api.openweathermap.org/data/2.5")
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }
}