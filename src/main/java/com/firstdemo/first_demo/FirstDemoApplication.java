package com.firstdemo.first_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstDemoApplication {



    public static void main(String[] args) {
        SpringApplication.run(FirstDemoApplication.class, args);

    System.out.println("welcome");
    }

}
