package com.arcgen.hmp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HmpApplication {
	public static void main(String[] args) {
		SpringApplication.run(HmpApplication.class, args);
                System.out.println("Backend running...");
	}

}
