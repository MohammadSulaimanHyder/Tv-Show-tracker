package com.app.tvshowtracker.services;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.app.tvshowtracker.customException.TvShowTrackerException;
import com.app.tvshowtracker.model.UserDetailsImpl;

@Service
public class MailService {
	
	private JavaMailSender mail;
	
	@Async
	public void sendRegistrationMail(UserDetailsImpl userDetails, String token) {
		
		MimeMessagePreparator messagePrep = mimeMessage -> {
			MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
			message.setFrom("votingsystem@email.com");
			message.setTo(userDetails.getEmail());
			message.setSubject("Please activate your account");
			message.setText("<h4>Thank you for signing up, Please click on the below link to signup:</h4>\r\n"
					+ "<a href=\"http://localhost:8080/app/auth/accountVerification/" + token + "/" + userDetails.getUserId() + "\">\r\n"
					+ "<button style=\"background-color: #555555;color: white; font-size: 20px;border-radius: 4px;\">Register</button></a>");
		};
		
		try
		{
			mail.send(messagePrep);
		} catch(Exception e) {
			new TvShowTrackerException("Exception occurred when sending Registration mail to " + userDetails.getEmail(), e);
		}
		
	}

}
