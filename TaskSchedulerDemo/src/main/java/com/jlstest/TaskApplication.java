package com.jlstest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author JLS
 * @description:
 * @since 2024-02-20 10:27
 */
@SpringBootApplication
public class TaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskApplication.class, args);
        System.out.println("TaskApplication is running!");
    }
}
