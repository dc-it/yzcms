package com.mapc.yzcms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class YzcmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(YzcmsApplication.class, args);
    }

}
