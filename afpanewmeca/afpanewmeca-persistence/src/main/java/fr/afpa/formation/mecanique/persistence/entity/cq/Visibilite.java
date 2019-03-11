package fr.afpa.formation.mecanique.persistence.entity.cq;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Visibilite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;
	private boolean pareBrise;
	private boolean vitrage;
	private boolean essuieGlaceAvant;
	private boolean essuieGlaceArriere;
	private boolean laveGlace;
	private boolean lavePhare;
	private boolean retroInterieur;
	private boolean retroExterieur;
	private boolean immatriculation;

	public Visibilite(boolean pareBrise, boolean vitrage, boolean essuieGlaceAvant, boolean essuieGlaceArriere,
			boolean laveGlace, boolean lavePhare, boolean retroInterieur, boolean retroExterieur,
			boolean immatriculation) {
		super();
		this.pareBrise = pareBrise;
		this.vitrage = vitrage;
		this.essuieGlaceAvant = essuieGlaceAvant;
		this.essuieGlaceArriere = essuieGlaceArriere;
		this.laveGlace = laveGlace;
		this.lavePhare = lavePhare;
		this.retroInterieur = retroInterieur;
		this.retroExterieur = retroExterieur;
		this.immatriculation = immatriculation;
	}

	public Visibilite() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isPareBrise() {
		return pareBrise;
	}

	public void setPareBrise(boolean pareBrise) {
		this.pareBrise = pareBrise;
	}

	public boolean isVitrage() {
		return vitrage;
	}

	public void setVitrage(boolean vitrage) {
		this.vitrage = vitrage;
	}

	public boolean isEssuieGlaceAvant() {
		return essuieGlaceAvant;
	}

	public void setEssuieGlaceAvant(boolean essuieGlaceAvant) {
		this.essuieGlaceAvant = essuieGlaceAvant;
	}

	public boolean isEssuieGlaceArriere() {
		return essuieGlaceArriere;
	}

	public void setEssuieGlaceArriere(boolean essuieGlaceArriere) {
		this.essuieGlaceArriere = essuieGlaceArriere;
	}

	public boolean isLaveGlace() {
		return laveGlace;
	}

	public void setLaveGlace(boolean laveGlace) {
		this.laveGlace = laveGlace;
	}

	public boolean isLavePhare() {
		return lavePhare;
	}

	public void setLavePhare(boolean lavePhare) {
		this.lavePhare = lavePhare;
	}

	public boolean isRetroInterieur() {
		return retroInterieur;
	}

	public void setRetroInterieur(boolean retroInterieur) {
		this.retroInterieur = retroInterieur;
	}

	public boolean isRetroExterieur() {
		return retroExterieur;
	}

	public void setRetroExterieur(boolean retroExterieur) {
		this.retroExterieur = retroExterieur;
	}

	public boolean isImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(boolean immatriculation) {
		this.immatriculation = immatriculation;
	}

	@Override
	public String toString() {
		return "Visibilite [id=" + id + ", pareBrise=" + pareBrise + ", vitrage=" + vitrage + ", essuieGlaceAvant="
				+ essuieGlaceAvant + ", essuieGlaceArriere=" + essuieGlaceArriere + ", laveGlace=" + laveGlace
				+ ", lavePhare=" + lavePhare + ", retroInterieur=" + retroInterieur + ", retroExterieur="
				+ retroExterieur + ", immatriculation=" + immatriculation + "]";
	}

}
