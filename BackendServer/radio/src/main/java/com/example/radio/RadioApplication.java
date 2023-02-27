package com.example.radio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class RadioApplication {

	public static void main(String[] args) {
		SpringApplication.run(RadioApplication.class, args);
	}

}
