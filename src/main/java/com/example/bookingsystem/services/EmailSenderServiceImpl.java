package com.example.bookingsystem.services;

import com.example.bookingsystem.entity.EmailBody;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderServiceImpl implements EmailSenderService{
	
	private final JavaMailSender mailSender;
	
	public EmailSenderServiceImpl(JavaMailSender mailSender) {
		this.mailSender=mailSender;
	}
	@Override
	public Boolean sendMailToUser(String emailId, EmailBody email) {
		// TODO Auto-generated method stub
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom("pallavjhaveri94@gmail.com");
		mailMessage.setTo(emailId);
		mailMessage.setSubject(email.getEmailSubject());
		mailMessage.setText(email.getEmailBody());
		
		mailSender.send(mailMessage);
		
		return true;
	}

}
