package tn.esprit.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Client;
import tn.esprit.entities.Compte;
import tn.esprit.entities.CompteRequest;
import tn.esprit.entities.TypeCompte;
import tn.esprit.repository.CompteRepository;

@Service
public class CompteService implements ICompteService {

	@Autowired
	CompteRepository cmptrep;

	@Autowired
	IClientService clientservice;
	
	private String randRib;

	@Override
	public Compte ajouterCompte(CompteRequest rcompte ) {
		// TODO Auto-generated method stub
		Client c = clientservice.getClientById(rcompte.getId_Client());
		randRib = RandomStringUtils.random(16, "0123456789");
		Compte cmpt = new Compte(0, new Date(), randRib, rcompte.getTypeCompte());
		cmpt.setClient(c);
		return cmptrep.save(cmpt);
	}

	@Override
	public boolean supprimerCompte(int id) {
		// TODO Auto-generated method stub
		cmptrep.deleteById(id);
		return cmptrep.existsById(id);
	}

	@Override
	public Compte trouverCompteById(int id) {
		// TODO Auto-generated method stub
		return cmptrep.findById(id).get();
	}

	@Override
	public List<Compte> trouverToutCompteCourant() {
		// TODO Auto-generated method stub
		//return cmptrep.getAllCompteCourant();
		return cmptrep.findByTypeCompte(TypeCompte.COURANT);
	}

	@Override
	public List<Compte> trouverToutCompteEPARGNE() {
		// TODO Auto-generated method stub
		//return cmptrep.getAllCompteEpargne();
		return cmptrep.findByTypeCompte(TypeCompte.EPARGNE);
	}

	@Override
	public int retournerNombreCompteCourants() {
		// TODO Auto-generated method stub
		return cmptrep.countCompteType(TypeCompte.COURANT);
	}

	@Override
	public int retournerNombreCompteEPARGNE() {
		// TODO Auto-generated method stub
		return cmptrep.countCompteType(TypeCompte.EPARGNE);
	}

	@Override
	public Compte trouverCompteByRIB(String rib) {
		// TODO Auto-generated method stub
		return cmptrep.findByRib(rib);
	}

	@Override
	public List<Compte> trouverToutCompte() {
		// TODO Auto-generated method stub
		return (List<Compte>) cmptrep.findAll();
	}

	@Override
	public int retournerNombreCompte() {
		// TODO Auto-generated method stub
		return cmptrep.countCompte();
	}

}
