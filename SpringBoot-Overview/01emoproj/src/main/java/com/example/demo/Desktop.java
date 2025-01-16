package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class Desktop implements Computer{

    @Override
    public void compile() {
        System.out.println("Compiling with 404 error but faster ");
    }
}
