package com.inmobiliaria;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiAppInmobiliariaApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ApiAppInmobiliariaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Iniciando proceso");
	}

}
