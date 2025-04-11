package com.leads.leadmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@SpringBootApplication
@ComponentScan(basePackages = "com.leads.leadmanagement")
public class LeadmanagementApplication implements CommandLineRunner {

	@Autowired
	private Environment env;


	public static void main(String[] args) {
		SpringApplication.run(LeadmanagementApplication.class, args);
	}


	@Override
	public void run(String... args) {
		System.out.println("Database URL: " + env.getProperty("SPRING_DATASOURCE_URL"));
		System.out.println("Database Username: " + env.getProperty("SPRING_DATASOURCE_USERNAME"));
	}
}
