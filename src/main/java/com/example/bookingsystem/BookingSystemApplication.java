package com.example.bookingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example	")
public class BookingSystemApplication {
	
	public static void main(String[] args) {	
		SpringApplication.run(BookingSystemApplication.class, args);
	}

}
