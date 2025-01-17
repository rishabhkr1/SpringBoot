package com.daytona.SpringCore.rest;

import com.daytona.SpringCore.common.coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class demoController {

    //define a private field for the dependency

//    @Autowired
    private coach myCoach;


    // creating a constructor (constructor injection)
//    @Autowired
//    public demoController(coach theCoach){
//        myCoach=theCoach;
//    }


    //Setter Injection
    @Autowired
    public void setCoach(coach thecoach){
        myCoach=thecoach;
    }

    // getmapping for mapping
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

}
