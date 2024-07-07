package com.tbemerencio.salesnotification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SalesnotificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesnotificationApplication.class, args);
	}

}
