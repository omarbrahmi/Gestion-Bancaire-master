package tn.esprit.controller;
import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.config.GeneratePdfReport;
import tn.esprit.entities.Client;
import tn.esprit.entities.Facture;
import tn.esprit.service.ClientService;
import tn.esprit.service.FactureService;

@RestController
public class FactureRestControlImpl {
	
	@Autowired
	FactureService factureService;
	
	@Autowired
	ClientService clientser;
    
	@GetMapping("/auth/admin/retrieve-all-factures")
	public List<Facture> retrieveALLFacture() {
		List<Facture> factures = factureService.retrieveALLFactures();
		return factures;
	}
	
	@GetMapping("/auth/client/retrieve-all-factures-client/{id}")
	public List<Facture> retrieveALLFactureclient(@PathVariable long id) {
		List<Facture> factures = factureService.retrieveALLFacturesClient(id);
		return factures;
	}
	
	@PostMapping("/auth/client/add-facture/{id}")
	@ResponseBody
	public Facture addFacture(@RequestBody Facture facture, @PathVariable long id) {
	 factureService.addFacture(facture, id);
		return facture;
	}

	
	@PutMapping("/auth/client/modify-facture")
	@ResponseBody
	public Facture modifyFacture(@RequestBody Facture facture) {
		return factureService.updateFacture(facture);
	}

	
		 @GetMapping("/auth/client/retrieve-facture/{facture-id}")
		 public  Facture retrieveFacture(@PathVariable("facture-id") Long ref){
			 return factureService.retrieveFacture(ref);
		 }
		
		 
		 @RequestMapping(value = "/auth/client/pdfreport/{id}", method = RequestMethod.GET,
		            produces = MediaType.APPLICATION_PDF_VALUE)
		    public ResponseEntity<InputStreamResource> citiesReport(@PathVariable long id) {

		        List<Facture> facts = factureService.retrieveALLFacturesClient(id);
		        Client c = clientser.getClientById(id);
		        ByteArrayInputStream bis = GeneratePdfReport.FactureReport(facts, c);

		        HttpHeaders headers = new HttpHeaders();
		        headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

		        return ResponseEntity
		                .ok()
		                .headers(headers)
		                .contentType(MediaType.APPLICATION_PDF)
		                .body(new InputStreamResource(bis));
		    }
		 
		 
}
