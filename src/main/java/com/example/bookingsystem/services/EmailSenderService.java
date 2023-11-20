package com.example.bookingsystem.services;

import com.example.bookingsystem.entity.EmailBody;

public interface EmailSenderService {
	public Boolean sendMailToUser(String string, EmailBody email);
}
