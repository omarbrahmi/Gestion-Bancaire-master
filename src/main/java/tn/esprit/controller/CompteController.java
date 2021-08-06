package tn.esprit.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.entities.Compte;
import tn.esprit.entities.CompteRequest;
import tn.esprit.service.ICompteService;

@RestController
public class CompteController {

	private static final Logger logger = LogManager.getLogger(CompteController.class);
	
	@Autowired
	ICompteService cmpt;
	
	@PostMapping("/auth/client/addcompte")
	public Compte ajoutercompte(@RequestBody CompteRequest c){
		Compte r = cmpt.ajouterCompte(c);
		logger.info("------------------Add Compte-------------------------");
		return r;
	}
	
	@DeleteMapping("/auth/admin/compte/delete/{id}")
	public boolean supprimercompte(@PathVariable int id){
		Boolean r = cmpt.supprimerCompte(id);
		logger.info("------------------Delete Compte-------------------------");
		return r;
	}
	
	@GetMapping("/auth/client/compte/get/{id}")
	public Compte getCompteByid(@PathVariable int id){
		Compte r = cmpt.trouverCompteById(id);
		logger.info("------------------Get Compte-------------------------");
		return r;
	}
	
	@GetMapping("/auth/admin/compte/get/{id}")
	public Compte getCompteByidd(@PathVariable int id){
		Compte r = cmpt.trouverCompteById(id);
		logger.info("------------------Get Compte-------------------------");
		return r;
	}
	
	@GetMapping("/auth/client/compte/getrib/{rib}")
	public Compte getCompteByRIBbb(@PathVariable String rib){
		Compte r = cmpt.trouverCompteByRIB(rib);
		logger.info("------------------Get Compte By RIB -------------------------");
		return r;
	}
	
	@GetMapping("/auth/admin/compte/getrib/{rib}")
	public Compte getCompteByRIbb(@PathVariable String rib){
		Compte r = cmpt.trouverCompteByRIB(rib);
		logger.info("------------------Get Compte By RIB-------------------------");
		return r;
	}
	
	
	@GetMapping("/auth/admin/compte")
	public List<Compte> getAllcompte(){
		List<Compte> r = cmpt.trouverToutCompte();
		logger.info("------------------All Compte-------------------------");
		return r;
	}
	
	@GetMapping("/auth/admin/compte/courant")
	public List<Compte> getallCompteCourant(){
		List<Compte> r = cmpt.trouverToutCompteCourant();
		logger.info("------------------All Compte Courant-------------------------");
		return r;
	}
	
	@GetMapping("/auth/admin/compte/epargne")
	public List<Compte> getallCompteEpargne(){
		List<Compte> r = cmpt.trouverToutCompteEPARGNE();
		logger.info("------------------All Compte Epargne-------------------------");
		return r;
	}
	
	@GetMapping("/auth/admin/compte/count")
	public int getcountCompte(){
		int r = cmpt.retournerNombreCompte();
		logger.info("------------------Count Compte-------------------------");
		return r;
	}
	
	@GetMapping("/auth/admin/compte/count/courant")
	public int getcountCompteCourant(){
		int r = cmpt.retournerNombreCompteCourants();
		logger.info("------------------Count Compte Courant-------------------------");
		return r;
	}
	
	@GetMapping("/auth/admin/compte/count/epargne")
	public int getcountCompteEpargne(){
		int r = cmpt.retournerNombreCompteEPARGNE();
		logger.info("------------------Count Compte Epargne-------------------------");
		return r;
	}
	
}
