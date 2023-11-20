package com.example.bookingsystem.entity;

import org.springframework.stereotype.Component;

@Component
public class EmailBody {
	
	private String emailBody;
	private String emailSubject;
	public String getEmailBody() {
		return emailBody;
	}
	public void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
	}
	public String getEmailSubject() {
		return emailSubject;
	}
	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}
	
	

}
