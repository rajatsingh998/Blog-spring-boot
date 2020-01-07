package com.firstdemo.first_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication

public class FirstDemoApplication extends SpringBootServletInitializer {



    public static void main(String[] args) {
        SpringApplication.run(FirstDemoApplication.class, args);

    System.out.println("welcome");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(FirstDemoApplication.class);
    }
}
