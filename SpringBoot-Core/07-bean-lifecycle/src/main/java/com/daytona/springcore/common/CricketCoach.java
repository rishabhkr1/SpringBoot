package com.daytona.springcore.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component //marks the class as spring bean
public class CricketCoach implements Coach {

    public CricketCoach(){
        System.out.println("In constructor "+getClass().getSimpleName());
    }

    //Define init method
    @PostConstruct
    public void doStart(){
        System.out.println("In do stuff methods "+getClass().getSimpleName());
    }

    //define destroy method
    //@PreDestroy
    @PreDestroy
    public void doClean(){
        System.out.println("In clean stuff methods "+getClass().getSimpleName());
    }

    public String getDailyWorkout() {
        return "practice fast bowling for 15min ";
    }

}
