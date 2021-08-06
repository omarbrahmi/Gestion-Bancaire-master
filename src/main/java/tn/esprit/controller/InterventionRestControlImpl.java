package tn.esprit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.entities.Intervention;
import tn.esprit.entities.TypeIntervention;
import tn.esprit.service.IInterventionService;



@RestController
@RequestMapping("/auth")
public class InterventionRestControlImpl {

	
	@Autowired
	 IInterventionService interService;

	 @GetMapping("/admin/allintervention")
	public List<Intervention> getInterventions() {
	List<Intervention> list = interService.AllInterventions();
	return list;
	}

	 @GetMapping("/admin/getintervention/{intervention-id}")
	 public Intervention getByIdIntervention(@PathVariable("intervention-id") Long interventionId){
		 return interService.getIntervention(interventionId);
	 }

	 
	 @PostMapping("/client/add-intervention/{id}")
	 public Intervention addIntervention(@RequestBody Intervention i, @PathVariable long id){
		 Intervention intervention=interService.addInterventions(i, id);
		 return intervention;
	 }


	    @GetMapping(value = "/admin/getNombreInterventionJPQL")
		public long getNombreInterventionJPQL() {
	    	return interService.getNombreInterventionJPQL();
	    }

}
