package tn.esprit.service;

import java.util.List;


import tn.esprit.entities.Intervention;
import tn.esprit.entities.TypeIntervention;



public interface IInterventionService {

	List<Intervention> AllInterventions();
	Intervention addInterventions(Intervention inter, long id);
	Intervention getIntervention(Long id);
	public long getNombreInterventionJPQL();
	
}
