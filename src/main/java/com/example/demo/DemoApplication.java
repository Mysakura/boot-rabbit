package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;

import java.util.Date;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Bean
	public Converter<String,Date> timeConverter(){
		return new Converter<String, Date>() {
			@Override
			public Date convert(String s) {
				return new Date(Long.parseLong(s));
			}
		};
	}
}
