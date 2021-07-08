package com.dreamteam.dreammovie;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DreammovieApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DreammovieApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}