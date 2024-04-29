package com.Student_nativeQuery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.github.javafaker.Faker;

@SpringBootApplication
@EnableWebMvc
public class StudentNativeQueryApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentNativeQueryApplication.class, args);
	}
	@Bean
	Faker faker() {
		return new Faker();
	}

}
