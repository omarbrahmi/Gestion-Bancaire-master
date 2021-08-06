package tn.esprit.controller;

import com.twilio.exception.ApiException;


import tn.esprit.entities.SMS;
import tn.esprit.service.SMSService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class SMSController {

	private static final Logger logger = LogManager.getLogger(SMSController.class);
	
    @Autowired
    SMSService service;

    @Autowired
    private SimpMessagingTemplate webSocket;

    private final String  TOPIC_DESTINATION = "/topic/sms";

   
	@RequestMapping(value = "/auth/admin/sendsms", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public void smsSubmit(@RequestBody SMS sms) {

            service.send(sms);
    		logger.info("------------------Send SMS -------------------------");
    }

    }
