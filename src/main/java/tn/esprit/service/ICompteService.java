package tn.esprit.service;

import java.util.List;


import org.springframework.stereotype.Service;

import tn.esprit.entities.Compte;
import tn.esprit.entities.CompteRequest;
@Service
public interface ICompteService {

	public Compte ajouterCompte(CompteRequest rcompte);

	public boolean supprimerCompte(int id);

	public Compte trouverCompteById(int idCompte);
	
	public Compte trouverCompteByRIB(String rib);
	
	public List<Compte> trouverToutCompte();

	public List<Compte> trouverToutCompteCourant();
	
	public List<Compte> trouverToutCompteEPARGNE();
	
	public int retournerNombreCompte();
	
	public int retournerNombreCompteCourants();
	
	public int retournerNombreCompteEPARGNE();
	
	
}
