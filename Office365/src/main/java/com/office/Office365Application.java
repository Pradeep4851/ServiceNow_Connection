package com.office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.office.service.EmailService;

@SpringBootApplication
public class Office365Application implements CommandLineRunner {
	
	@Autowired
	private EmailService emailService;

	public static void main(String[] args) {
		SpringApplication.run(Office365Application.class, args);
	}

	@Override
    public void run(String... args) {
        System.out.println("Fetching emails...");

        emailService.readEmails();;
        
    }
}
