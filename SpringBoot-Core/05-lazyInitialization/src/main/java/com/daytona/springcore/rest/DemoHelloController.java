package com.daytona.springcore.rest;

import com.daytona.springcore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoHelloController {

    private final Coach myCoach;

    @Autowired
    public DemoHelloController(@Qualifier("cricketCoach") Coach theCoach){
        System.out.println("In constructor "+getClass().getSimpleName());

        myCoach=theCoach;
    }

    //@RequestMapping(method = RequestMethod.GET, path = "/workout")
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

}
