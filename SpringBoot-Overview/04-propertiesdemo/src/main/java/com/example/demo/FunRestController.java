package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {


    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    //expose new endpoint for teaminfo
    @GetMapping("/teaminfo")
    public String teamInfo() {
        return "Coach : "+coachName+", Team Name : " + teamName;
    }
}
