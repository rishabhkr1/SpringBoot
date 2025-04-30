package com.daytona.cruddemo.rest;

import com.daytona.cruddemo.service.ApiService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class ApiController {

    private final ApiService apiService;

    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping()
    public String getPost(){
        return apiService.getSinglePost();
    }

    @PostMapping()
    public String createPost(){
        return apiService.createPost();
    }

    @PutMapping
    public String updatePost(){
        return apiService.updatePost();
    }

    public String deletePost(){
        apiService.delete();
        return "Post deleted successfully";
    }
}
