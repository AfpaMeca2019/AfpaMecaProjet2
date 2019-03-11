package fr.afpa.formation.mecanique.persistence.entity.or;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Piece {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;
	private String reference;
	private String libelle;
	private double prixUnitaire;

	public Piece(String reference, String libelle, double prixUnitaire) {
		super();
		this.reference = reference;
		this.libelle = libelle;
		this.prixUnitaire = prixUnitaire;
	}

	public Piece() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	@Override
	public String toString() {
		return "Piece [id=" + id + ", reference=" + reference + ", libelle=" + libelle + ", prixUnitaire="
				+ prixUnitaire + "]";
	}

}