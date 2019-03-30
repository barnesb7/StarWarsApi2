package com.detroitlabs.starWarsApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
public class AppConfiguration {

    public static void man(String[] args){
        SpringApplication.run(AppConfiguration.class, args);
    }

}
