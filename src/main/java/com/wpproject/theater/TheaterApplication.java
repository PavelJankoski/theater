package com.wpproject.theater;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class TheaterApplication {

    public static void main(String[] args) {
        SpringApplication.run(TheaterApplication.class, args);
    }

}
