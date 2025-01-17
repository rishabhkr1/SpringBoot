package com.daytona.springcore.common;

import jdk.jfr.Label;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {

    public TrackCoach(){
        System.out.println("In constructor "+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "run 5k daily";
    }
}
