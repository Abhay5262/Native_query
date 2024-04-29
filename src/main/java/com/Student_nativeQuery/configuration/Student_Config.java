package com.Student_nativeQuery.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Student_Config {
	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfoDetails()).select()
				.apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
	}
	private ApiInfo apiInfoDetails() {
		return new ApiInfo("student_Project", "Api_for_stuednt_project", "V.1.0", "term and condition",
				new Contact("Abhay", "Url", "@gmail.com"),"Licence_text","URL",Collections.emptyList());
		
	}
}
