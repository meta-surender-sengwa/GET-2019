package com.metacube.assignment;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class App {

	public static void main(String[] args) {

		// read the configuration of our app
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		
		// getting the bean by using context
		AppController app = (AppController)context.getBean("appController");
		
		// using the bean object
		app.getMail().sendMail();
		
	}

}