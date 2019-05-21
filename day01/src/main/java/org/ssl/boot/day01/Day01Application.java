package org.ssl.boot.day01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.ssl.boot.day01.Controller")
public class Day01Application {

    public static void main(String[] args) {
        SpringApplication.run(Day01Application.class, args);
        System.out.println("============start Day01Application===========");
    }

}
