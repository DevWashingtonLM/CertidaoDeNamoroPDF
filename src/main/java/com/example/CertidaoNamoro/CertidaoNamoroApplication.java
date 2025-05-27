package com.example.CertidaoNamoro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.certidao", "security", "controller", "service", "model", "util", "resources"})
public class CertidaoNamoroApplication {

	public static void main(String[] args) {
		SpringApplication.run(CertidaoNamoroApplication.class, args);
	}

}
