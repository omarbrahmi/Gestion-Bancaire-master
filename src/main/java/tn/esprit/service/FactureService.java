package tn.esprit.service;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Facture;
import tn.esprit.repository.FactureRepository;


@Service
public class FactureService implements IFactureService {

	@Autowired
	private FactureRepository factureRepository;
	
	@Autowired
	ClientService clientser;
	
	@Override
	public List <Facture> retrieveALLFactures() {
			List <Facture> factures =(List<Facture>)factureRepository.findAll();	
			return factures;
	}

	@Override
	public Facture addFacture(Facture facture, long id) { 
		facture.setClient(clientser.getClientById(id));
		facture.setDate(new Date());
		factureRepository.save(facture);
		return facture;
	}

	@Override
	public Facture updateFacture(Facture facture) {
		Facture fact = factureRepository.findById(facture.getRef()).get();
		fact.setTitre(facture.getTitre());
		fact.setMontant(facture.getMontant());
		factureRepository.save(fact);
		return fact;
	}

	@Override
	public void deleteFacture(long ref) {
		Facture fact= factureRepository.findById(ref).get();
		 factureRepository.delete(fact);
	}

	@Override
	public Facture retrieveFacture(long ref) {
		return factureRepository.findById(ref).get();
	}

	@Override
	public List<Facture> retrieveALLFacturesClient(long id) {
		// TODO Auto-generated method stub
		return factureRepository.findByClient(clientser.getClientById(id));
	}

}
