package com.sergio.springboot4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.resilience.annotation.EnableResilientMethods;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableResilientMethods
@EnableAsync
public class SpringBoot4Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot4Application.class, args);
	}

}
