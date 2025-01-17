package com.daytona.springcore.rest;

import com.daytona.springcore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private  Coach myCoach;


    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach){
        myCoach=theCoach;
    }

    //@RequestMapping(method = RequestMethod.GET, path = "/workout")
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
