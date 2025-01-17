package com.daytona.springcore.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component //marks the class as spring bean
public class CricketCoach implements Coach {

    public CricketCoach(){
        System.out.println("In constructor: "+getClass().getSimpleName());
    }

    public String getDailyWorkout() {
        return "practice fast bowling for 15min ";
    }


}
