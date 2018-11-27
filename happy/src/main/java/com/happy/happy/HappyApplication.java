package com.happy.happy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.happy.happy"})
public class HappyApplication {

	public static void main(String[] args) {
		SpringApplication.run(HappyApplication.class, args);
	}
}
