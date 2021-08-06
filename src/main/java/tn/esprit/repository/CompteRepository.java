package tn.esprit.repository;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.entities.Compte;
import tn.esprit.entities.TypeCompte;

@Repository
public interface CompteRepository extends CrudRepository<Compte, Integer> {

	public Compte findByRib(String rib);
	
	@Query("SELECT count(*) FROM Compte")
	@Transactional
    public int countCompte();
	
	@Query("SELECT count(*) FROM Compte WHERE typeCompte = :type ")
	@Transactional
    public int countCompteType(@Param("type") TypeCompte type);
	
	/*@Query("SELECT count(*) FROM Compte WHERE typeCompte = EPARGNE ")
	@Transactional
    public int countCompteEpargne();*/
	
	
	List<Compte> findByTypeCompte(TypeCompte type);
	
	
}
