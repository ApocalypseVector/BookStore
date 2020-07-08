package com.weblog.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlogApplication {
    public static void main(String[] args) {
        System.out.println("大家好才是真的好");
        SpringApplication.run(BlogApplication.class, args); }
}