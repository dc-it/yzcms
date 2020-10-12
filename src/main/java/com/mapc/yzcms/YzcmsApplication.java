package com.mapc.yzcms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableTransactionManagement
@EnableJpaAuditing
@SpringBootApplication
public class YzcmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(YzcmsApplication.class, args);
	}
}
