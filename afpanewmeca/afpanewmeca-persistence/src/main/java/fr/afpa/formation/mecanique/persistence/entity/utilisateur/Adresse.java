package fr.afpa.formation.mecanique.persistence.entity.utilisateur;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="adresse")
public class Adresse {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;
	@Column(nullable = false)
	private String adresse;
	@Column(nullable = false)
	private String codePostal;
	@Column(nullable = false)
	private String ville;

	@Override
	public String toString() {
		return "Adresse [id=" + id + ", adresse=" + adresse + ", codePostal=" + codePostal + ", ville=" + ville + "]";
	}

	public Adresse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Adresse(String adresse, String codePostal, String ville) {
		super();
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

}
