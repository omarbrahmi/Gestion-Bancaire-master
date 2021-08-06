package tn.esprit.service;

import org.springframework.stereotype.Service;

import tn.esprit.entities.Client;
import tn.esprit.entities.Compte;

@Service
public interface IClientService {

	public Compte ajouterClient(Client client);
	
	public Client getClientById(Long id);
	
	public Client updateClient(Client client);
	
	public boolean resetpassword(String currentpass , String newpass);
	
}
