package com.daytona.SpringCore;

import org.springframework.stereotype.Component;

@Component //marks the class as spring bean
public class cricketCoach implements coach{


    public String getDailyWorkout() {
        return "practice fast bowling for 15min ";
    }
}
