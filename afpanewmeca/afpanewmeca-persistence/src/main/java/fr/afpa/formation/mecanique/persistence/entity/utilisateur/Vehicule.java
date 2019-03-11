package fr.afpa.formation.mecanique.persistence.entity.utilisateur;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="vehicule")
public class Vehicule {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;
	@Column(nullable = false)
	private String marque;
	@Column(nullable = false)
	private String modele;
	@Column(nullable = false)
	private double kilometrage;
	@Column(nullable = false)
	private String numeroCarteGrise;
	@Column(nullable = false)
	private String numeroAssurance;
	@Column(nullable = false)
	private String immatriculation;
	@Column(nullable = false)
	private String vin;
	@Column(nullable = false)
	private Date dateMiseEnCirculation;

	public Vehicule(String marque, String modele, double kilometrage, String numeroCarteGrise, String numeroAssurance,
			String immatriculation, String vin, Date dateMiseEnCirculation) {
		super();
		this.marque = marque;
		this.modele = modele;
		this.kilometrage = kilometrage;
		this.numeroCarteGrise = numeroCarteGrise;
		this.numeroAssurance = numeroAssurance;
		this.immatriculation = immatriculation;
		this.vin = vin;
		this.dateMiseEnCirculation = dateMiseEnCirculation;
	}

	public Vehicule() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public double getKilometrage() {
		return kilometrage;
	}

	public void setKilometrage(double kilometrage) {
		this.kilometrage = kilometrage;
	}

	public String getNumeroCarteGrise() {
		return numeroCarteGrise;
	}

	public void setNumeroCarteGrise(String numeroCarteGrise) {
		this.numeroCarteGrise = numeroCarteGrise;
	}

	public String getNumeroAssurance() {
		return numeroAssurance;
	}

	public void setNumeroAssurance(String numeroAssurance) {
		this.numeroAssurance = numeroAssurance;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public Date getDateMiseEnCirculation() {
		return dateMiseEnCirculation;
	}

	public void setDateMiseEnCirculation(Date dateMiseEnCirculation) {
		this.dateMiseEnCirculation = dateMiseEnCirculation;
	}

	@Override
	public String toString() {
		return "Vehicule [id=" + id + ", marque=" + marque + ", modele=" + modele + ", kilometrage=" + kilometrage
				+ ", numeroCarteGrise=" + numeroCarteGrise + ", numeroAssurance=" + numeroAssurance
				+ ", immatriculation=" + immatriculation + ", vin=" + vin + ", dateMiseEnCirculation="
				+ dateMiseEnCirculation + "]";
	}

}
