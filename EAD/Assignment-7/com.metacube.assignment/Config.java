package com.metacube.assignment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("com.metacube.assignment")
public class Config {
	
	// this annotation specifies that whenever we need to get beans of type 'MailSender (return type)' it executes this method and returns MailSender object reference
	@Bean  
	public MailSender smtpMailSender() {
		return new SMTPMailSender();
	}
	
	@Bean
	//	2.2 handling more than one candidate bean problem using @primary annotation
	@Primary 	
	public MailSender mockMailSender() {
		return new MockMailSender();   
	}

}
