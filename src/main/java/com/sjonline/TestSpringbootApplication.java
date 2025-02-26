package com.sjonline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.sjonline")
public class TestSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestSpringbootApplication.class, args);
//		System.out.println("Hello world");
	}

}
