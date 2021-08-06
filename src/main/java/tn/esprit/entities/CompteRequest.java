package tn.esprit.entities;

public class CompteRequest {

	private Long id_Client;
	
	private TypeCompte typeCompte;

	public CompteRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public CompteRequest(Long id_Client, TypeCompte typeCompte) {
		super();
		this.id_Client = id_Client;
		this.typeCompte = typeCompte;
	}



	public Long getId_Client() {
		return id_Client;
	}

	public void setId_Client(Long id_Client) {
		this.id_Client = id_Client;
	}

	public TypeCompte getTypeCompte() {
		return typeCompte;
	}

	public void setTypeCompte(TypeCompte typeCompte) {
		this.typeCompte = typeCompte;
	}
	
	
	
	
}
