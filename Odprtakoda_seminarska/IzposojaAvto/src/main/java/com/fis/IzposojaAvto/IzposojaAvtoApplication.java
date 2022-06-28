package com.fis.IzposojaAvto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class IzposojaAvtoApplication {

	public static void main(String[] args) {
		SpringApplication.run(IzposojaAvtoApplication.class, args);
	}

}
