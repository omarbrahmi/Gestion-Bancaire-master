package tn.esprit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Intervention;
import tn.esprit.entities.TypeIntervention;
import tn.esprit.repository.InterventionRepository;

@Service
public class IntervetionService implements IInterventionService {

	@Autowired
	InterventionRepository interrep;
	
	@Autowired
	ClientService clientser;
	
	@Override
	public List<Intervention> AllInterventions() {
		List<Intervention> users= (List<Intervention>) interrep.findAll();
		return users;
	}


	@Override
	public Intervention addInterventions(Intervention inter, long id) {
		inter.setClient(clientser.getClientById(id));
		interrep.save(inter);
		return inter;
	}

	@Override
	public Intervention getIntervention(Long id) {
		return interrep.findById(id).get();
	}

	@Override
	public long getNombreInterventionJPQL() {
		return interrep.countinter();
	}

}
