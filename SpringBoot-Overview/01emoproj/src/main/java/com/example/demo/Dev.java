package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
public class Dev {

    //field injection
   // @Autowired
    private  Computer comp;

    // Constructor injection
//    public Dev(Computer deskto){
//        this.comp=deskto;
//    }

    //SetterInjection
   @Autowired
    public void setMylaptop(@Qualifier("desktop") Computer mylaptop) {
        this.comp = mylaptop;
    }

    public void build(){
        comp.compile();
        System.out.println("Hello springBoot....");
    }
}
