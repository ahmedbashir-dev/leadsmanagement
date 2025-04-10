package com.leads.leadmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.leads.leadmanagement")
public class LeadmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeadmanagementApplication.class, args);
	}

}
