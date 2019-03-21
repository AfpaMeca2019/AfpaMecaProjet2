package fr.afpa.formation.mecanique.persistence.entity.cq;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="controleQualite")
public class ControleQualite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;
	public Long getId() {
		return id;
	}

	private Date dateDebut;
	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	private Long kilometrageFin;
	private String observation;
	@OneToOne
	private Pneumatique p;
	@OneToOne
	private Niveau n;
	@OneToOne
	private Eclairage e;
	@OneToOne
	private Visibilite v;

	public Long getKilometrageFin() {
		return kilometrageFin;
	}

	public void setKilometrageFin(Long kilometrageFin) {
		this.kilometrageFin = kilometrageFin;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public ControleQualite() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ControleQualite(Date dateDebut) {
		super();
		this.dateDebut = dateDebut;
	}

	public Pneumatique getP() {
		return p;
	}

	public void setP(Pneumatique p) {
		this.p = p;
	}

	public Niveau getN() {
		return n;
	}

	public void setN(Niveau n) {
		this.n = n;
	}

	public Eclairage getE() {
		return e;
	}

	public void setE(Eclairage e) {
		this.e = e;
	}

	public Visibilite getV() {
		return v;
	}

	public void setV(Visibilite v) {
		this.v = v;
	}

}
