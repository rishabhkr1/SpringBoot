package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @GetMapping("/hi")
    public String hii() {
        return "Hello Spring";
    }

    @GetMapping("/workout")
    public String getWorkout(){
        return "Doing workout";
    }
    @GetMapping("/working")
    public String getwork(){
        return "Working";
    }
}
