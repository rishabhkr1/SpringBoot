package com.daytona.cruddemo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ApiService {

    private final WebClient webClient;

    public ApiService(WebClient webClient) {
        this.webClient = webClient;
    }
    public String getSinglePost(){
        long startTime=System.currentTimeMillis();

        String response=webClient.get()
                .uri("posts/1")
                .retrieve()
                .bodyToMono(String.class)
                .block();

        long endTime=System.currentTimeMillis();
        System.out.println("Response; "+response);

        System.out.println("Time taken: "+(endTime-startTime)+"ms");
        return response;
    }

    public String createPost() {
        String requestBody = "{ \"title\": \"foo\", \"body\": \"bar\", \"userId\": 1 }";

        String response = webClient.post()
                .uri("/posts")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        System.out.println("Created Post: " + response);
        return response;
    }

    public String updatePost(){
        String requestBody =  "{ \"id\": 1, \"title\": \"updated title\", \"body\": \"updated body\", \"userId\": 1 }";

        String response =webClient.post()
                .uri("posts/1")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        System.out.println("Updated Post: "+response);
        return response;
    }

    public void delete(){
        webClient.delete()
                .uri("posts/1")
                .retrieve()
                .bodyToMono(void.class)
                .block();
        System.out.println("Post deleted successfully");
    }
}
