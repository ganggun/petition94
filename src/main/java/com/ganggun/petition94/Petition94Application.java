package com.ganggun.petition94;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Petition94Application {

    public static void main(String[] args) {
        SpringApplication.run(Petition94Application.class, args);
    }

}
