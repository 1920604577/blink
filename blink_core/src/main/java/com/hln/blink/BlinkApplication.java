package com.hln.blink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlinkApplication {
    public static void main(String[] args) {
        System.out.println("hello");
        SpringApplication.run(BlinkApplication.class, args);
    }
}
