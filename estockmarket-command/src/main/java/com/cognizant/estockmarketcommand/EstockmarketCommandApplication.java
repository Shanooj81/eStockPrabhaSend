package com.cognizant.estockmarketcommand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.modelmapper.ModelMapper;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class}
)
@EnableSwagger2
public class EstockmarketCommandApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstockmarketCommandApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
