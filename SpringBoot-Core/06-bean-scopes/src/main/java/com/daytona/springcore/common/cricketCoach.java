package com.daytona.springcore.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component //marks the class as spring bean
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class cricketCoach implements Coach {

    public cricketCoach(){
        System.out.println("In constructor "+getClass().getSimpleName());
    }

    public String getDailyWorkout() {
        return "practice fast bowling for 15min ";
    }
}
