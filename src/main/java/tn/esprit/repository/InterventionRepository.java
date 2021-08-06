package tn.esprit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.entities.Intervention;
import tn.esprit.entities.TypeIntervention;

@Repository
public interface InterventionRepository  extends CrudRepository<Intervention,Long> {

	@Query("SELECT count(*) FROM Intervention")
    public long countinter();
	 @Query("SELECT type FROM Intervention")
	    public List<String> interventiontype();
	 @Modifying
	 @Transactional
	    @Query("UPDATE Intervention e SET e.type=:type1 where e.id=:interventionId")
	    public void mettreAjourTypeByInterventionIdJPQL(@Param("type1")TypeIntervention type, @Param("interventionId")long interventionId);
	 
}
