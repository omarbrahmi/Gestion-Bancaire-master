package tn.esprit.repository;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.entities.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {

	Client findByUsername(String username);
	
	@Modifying
	@Transactional
	@Query("UPDATE Client c SET c.isenabled = true WHERE c.idClient  = :id")
	void enableClient(@Param("id") long id);
	
	@Modifying
	@Transactional
	@Query("UPDATE Client c SET c.isenabled = false WHERE c.idClient  = :id")
	void disableClient(@Param("id") long id);
	
}
