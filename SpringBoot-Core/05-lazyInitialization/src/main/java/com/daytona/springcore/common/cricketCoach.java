package com.daytona.springcore.common;

import org.springframework.stereotype.Component;

@Component //marks the class as spring bean
public class cricketCoach implements Coach {

    public cricketCoach(){
        System.out.println("In constructor "+getClass().getSimpleName());
    }

    public String getDailyWorkout() {
        return "practice fast bowling for 15min ";
    }
}
