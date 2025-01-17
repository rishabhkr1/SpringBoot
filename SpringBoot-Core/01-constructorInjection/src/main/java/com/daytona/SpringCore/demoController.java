package com.daytona.SpringCore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class demoController {

    //define a private field for the dependency
    private coach myCoach;


    // creating a constructor
    @Autowired
    public demoController(coach theCoach){
        myCoach=theCoach;
    }


    // getmapping for mapping
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

}
