package tn.esprit.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.entities.RequestMail;
import tn.esprit.service.EmailService;

@RestController

public class EmailController {

	private static final Logger logger = LogManager.getLogger(EmailController.class);
	
	@Autowired
	EmailService emailser;

	@PostMapping("/auth/admin/sendmail")
	@ResponseBody
	public boolean SendEmaill(@RequestBody RequestMail email) {
		boolean r = emailser.sendEmail(email.getSubject(), email.getMessage(), email.getTo());
		logger.info("------------------Send Mail-------------------------");
		return r;
	}

}