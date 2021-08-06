package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "intervention")
public class Intervention implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idIntervention")
	private Long id;
	

	@Enumerated(EnumType.STRING)
	private TypeIntervention type;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date date;
	
	private String description;
	
	@ManyToOne
	private Client client;
	
	
	public Intervention() {
		super();
	}

	public Intervention(TypeIntervention type, Date date, String description) {
		super();
		this.type = type;
		this.date = date;
		this.description = description;
	}

	public Intervention(Long id, TypeIntervention type, Date date, String description) {
		super();
		this.id = id;
		this.type = type;
		this.date = date;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TypeIntervention getType() {
		return type;
	}

	public void setType(TypeIntervention type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
	
}
