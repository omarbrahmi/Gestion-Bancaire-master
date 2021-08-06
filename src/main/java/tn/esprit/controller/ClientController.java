package tn.esprit.controller;

import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.config.WebsecurityConfig;
import tn.esprit.entities.Client;
import tn.esprit.entities.Compte;
import tn.esprit.entities.TypeClient;
import tn.esprit.service.ClientService;

@RestController
public class ClientController {

	private static final Logger logger = LogManager.getLogger(ClientController.class);
	
	@Autowired
	ClientService clients;
	
	
	@PostMapping("/addClient")
	@ResponseBody
	public Compte ajoutClient(@RequestBody Client c){
		Compte r= clients.ajouterClient(c);
		logger.info("------------------Add Account-------------------------");
		return r;
	}
	
	@GetMapping("/auth/client/get/{id}")
	public Client getclient(@PathVariable long id){
		Client r= clients.getClientById(id);
		logger.info("------------------Get Client-------------------------");
		return r;
	}
	
	@PutMapping("/auth/client/update")
	@ResponseBody
	public Client updateclient (@RequestBody Client client){
		Client r = clients.updateClient(client);
		logger.info("------------------Update Client-------------------------");
		return r;
	}
	
	
}
