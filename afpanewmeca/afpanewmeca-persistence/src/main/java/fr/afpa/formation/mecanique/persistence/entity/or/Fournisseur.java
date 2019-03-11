package fr.afpa.formation.mecanique.persistence.entity.or;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Fournisseur {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;
	private String codeFournisseur;
	private String nomFournisseur;

	public Fournisseur(String codeFournisseur, String nomFournisseur) {
		super();
		this.codeFournisseur = codeFournisseur;
		this.nomFournisseur = nomFournisseur;
	}

	public Fournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodeFournisseur() {
		return codeFournisseur;
	}

	public void setCodeFournisseur(String codeFournisseur) {
		this.codeFournisseur = codeFournisseur;
	}

	public String getNomFournisseur() {
		return nomFournisseur;
	}

	public void setNomFournisseur(String nomFournisseur) {
		this.nomFournisseur = nomFournisseur;
	}

	@Override
	public String toString() {
		return "Fournisseur [id=" + id + ", codeFournisseur=" + codeFournisseur + ", nomFournisseur=" + nomFournisseur
				+ "]";
	}

}
