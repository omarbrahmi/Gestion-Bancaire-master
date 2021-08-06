package tn.esprit.entities;


import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Compte {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCompte;
	
	private float soldeCompte;
	
	@Temporal(TemporalType.DATE)
	private Date dateCreationCompte;
	
	private String rib;
	
	@Enumerated(EnumType.STRING)
	private TypeCompte typeCompte;
	
	@ManyToOne
	private Client client;
	
	@ManyToOne
	private Agence agence;	
	   
	@OneToMany(mappedBy="compte")
	private List<Transaction> transactions;
	
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Compte(float soldeCompte, Date dateCreationCompte, String rib, TypeCompte typeCompte) {
		super();
		this.soldeCompte = soldeCompte;
		this.dateCreationCompte = dateCreationCompte;
		this.rib = rib;
		this.typeCompte = typeCompte;
	}

	public Compte(int idCompte, float soldeCompte, Date dateCreationCompte, String rib, TypeCompte typeCompte) {
		super();
		this.idCompte = idCompte;
		this.soldeCompte = soldeCompte;
		this.dateCreationCompte = dateCreationCompte;
		this.rib = rib;
		this.typeCompte = typeCompte;
	}



	public int getIdCompte() {
		return idCompte;
	}

	public float getSoldeCompte() {
		return soldeCompte;
	}

	public void setSoldeCompte(float soldeCompte) {
		this.soldeCompte = soldeCompte;
	}

	public Date getDateCreationCompte() {
		return dateCreationCompte;
	}

	public void setDateCreationCompte(Date dateCreationCompte) {
		this.dateCreationCompte = dateCreationCompte;
	}

	public String getRib() {
		return this.rib;
	}

	public void setRib(String rib) {
		this.rib = rib;
	}

	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public TypeCompte getTypeCompte() {
		return typeCompte;
	}

	public void setTypeCompte(TypeCompte typeCompte) {
		this.typeCompte = typeCompte;
	}

	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
	
}
