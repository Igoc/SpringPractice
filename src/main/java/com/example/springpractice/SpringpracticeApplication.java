package com.example.springpractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringpracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringpracticeApplication.class, args);
    }
}
