package com.metacube.assignment;

import org.springframework.stereotype.Component;

@Component
public interface MailSender {

	public void sendMail();
}
