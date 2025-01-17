package com.daytona.springcore.rest;

import com.daytona.springcore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private  Coach myCoach;

    private Coach anotherCoach;

    @Autowired
    public DemoController(
            @Qualifier("cricketCoach") Coach theCoach,
            @Qualifier("cricketCoach") Coach theAnotherCoach){
        System.out.println("In constructor "+getClass().getSimpleName());
        myCoach=theCoach;
        anotherCoach=theAnotherCoach;
    }



    //@RequestMapping(method = RequestMethod.GET, path = "/workout")
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
    @GetMapping("/check")
    public String check(){
        return "comparing beans: mycoach==anotherCoach "+(myCoach==anotherCoach);
    }

}
