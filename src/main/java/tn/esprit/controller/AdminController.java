package tn.esprit.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.entities.Client;
import tn.esprit.service.AdminService;

@RestController
public class AdminController {

	private static final Logger logger = LogManager.getLogger(AdminController.class);
	
	@Autowired
	AdminService service;
	
	@PostMapping("/auth/admin/disableaccount/{id}")
	public String DisableClient(@PathVariable long id){
		
		String r= service.disableClientById(id);
		logger.info("------------------Disable Account-------------------------");
		return r;
	}
	
	@PostMapping("/auth/admin/enableclient/{id}")
	public String EnableClient(@PathVariable long id){
		String r = service.EnableClientById(id);
		logger.info("------------------Enbale Account-------------------------");
		return r;
	}
	
	@GetMapping("/auth/admin/All")
	public List<Client> AllClient(){
		List<Client> r= service.getallClient();
		logger.info("------------------All Client-------------------------");
		return r;
	}
	
	@GetMapping("/auth/admin/get/{id}")
	public Client GetClient(@PathVariable long id){
		Client r = service.getClientById(id);
		logger.info("------------------Get Account-------------------------");
		return r;
	}
	
	@DeleteMapping("/auth/admin/delete/{id}")
	public Boolean DeleteClient(@PathVariable long id){
		Boolean r = service.deleteClient(id);
		logger.info("------------------Disable Account-------------------------");
		return r;
	}
	
	
	
	
	
	
}
