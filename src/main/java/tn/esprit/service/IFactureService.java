package tn.esprit.service;

import java.util.List;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Facture;

@Service
public interface IFactureService {
	public List<Facture>retrieveALLFactures();
	public Facture addFacture(Facture facture, long id); 
	public Facture updateFacture(Facture facture); 
	public void deleteFacture(long ref);
	public Facture retrieveFacture(long ref);
	public List<Facture> retrieveALLFacturesClient(long id);
    
}
