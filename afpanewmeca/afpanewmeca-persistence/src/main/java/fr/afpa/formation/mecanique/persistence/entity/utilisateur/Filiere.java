package fr.afpa.formation.mecanique.persistence.entity.utilisateur;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Filiere {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;
	private String libelle;

	public Filiere(String libelle) {
		super();
		this.libelle = libelle;
	}

	public Filiere() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Filiere [id=" + id + ", libelle=" + libelle + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}