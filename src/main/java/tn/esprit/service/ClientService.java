package tn.esprit.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;
import tn.esprit.config.WebsecurityConfig;
import tn.esprit.controller.SMSController;
import tn.esprit.entities.Client;
import tn.esprit.entities.Compte;
import tn.esprit.entities.CompteRequest;
import tn.esprit.entities.SMS;
import tn.esprit.repository.ClientRepository;

@Service
public class ClientService implements IClientService {

	@Autowired
	ClientRepository clientrep;

	@Autowired
	WebsecurityConfig webconf;

	@Autowired
	SMSService smsser;

	@Autowired
	CompteService cmptservice;

	private String username;
	private String password;

	@Override
	public Compte ajouterClient(Client client) {
		// TODO Auto-generated method stub

		username = RandomStringUtils.random(6, "0123456789");
		password = RandomStringUtils.random(6, "0123456789");

		client.setUsername(username);
		client.setPassword(webconf.passwordEncoder().encode(password));
		// client.setPassword( webconf.passwordEncoder().encode("123"));
		client.setRole("Client");
		client.setIsenabled(true);
		Client c = clientrep.save(client);

		Compte cmpt = cmptservice.ajouterCompte(new CompteRequest(c.getIdClient(), c.getTypeCompte()));

		SMS sms = new SMS();
		sms.setTo("+216" + c.getTelephone());
		sms.setMessage("Login: " + client.getUsername() + " password: " + password + " RIB: " + cmpt.getRib());
		smsser.send(sms);

		return cmpt;
	}

	@Override
	public Client getClientById(Long id) {
		// TODO Auto-generated method stub
		return clientrep.findById(id).get();
	}

	@Override
	public Client updateClient(Client client) {
		// TODO Auto-generated method stub
		return clientrep.save(client);
	}

	@Override
	public boolean resetpassword(String currentpass, String newpass) {
		// TODO Auto-generated method stub
		return false;
	}

	public UserDetails loadUserByUsername(String username) throws Exception {
		Client user = clientrep.findByUsername(username);
		if (user == null) {
			throw new NotFoundException("User not found");
		}

		return (UserDetails) user;
	}

}
