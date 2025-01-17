package com.daytona.SpringCore.rest;

import com.daytona.util.coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class demoController {

    //define a private field for the dependency

    //field Injection
//    @Autowired
    private coach myCoach;


    // creating a constructor for injection
//    @Autowired
//    public demoController(coach theCoach){
//        myCoach=theCoach;
//    }


    //using setter method for injection
    @Autowired
    public void setMyCoach(coach myCoach) {
        this.myCoach = myCoach;
    }

    // getmapping for mapping
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

}
