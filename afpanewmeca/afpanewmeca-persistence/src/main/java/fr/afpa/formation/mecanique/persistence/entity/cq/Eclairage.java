package fr.afpa.formation.mecanique.persistence.entity.cq;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Eclairage {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;
	private boolean feuxPosition;
	private boolean eclairageImmatriculation;
	private boolean feuxCroisement;
	private boolean feuxRoute;
	private boolean feuxJour;
	private boolean feuxDetresse;
	private boolean feuxStop;
	private boolean feuxAntiBrouillard;
	private boolean feuxRecul;

	public Eclairage(boolean feuxPosition, boolean eclairageImmatriculation, boolean feuxCroisement, boolean feuxRoute,
			boolean feuxJour, boolean feuxDetresse, boolean feuxStop, boolean feuxAntiBrouillard, boolean feuxRecul) {
		super();
		this.feuxPosition = feuxPosition;
		this.eclairageImmatriculation = eclairageImmatriculation;
		this.feuxCroisement = feuxCroisement;
		this.feuxRoute = feuxRoute;
		this.feuxJour = feuxJour;
		this.feuxDetresse = feuxDetresse;
		this.feuxStop = feuxStop;
		this.feuxAntiBrouillard = feuxAntiBrouillard;
		this.feuxRecul = feuxRecul;
	}

	public Eclairage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isFeuxPosition() {
		return feuxPosition;
	}

	public void setFeuxPosition(boolean feuxPosition) {
		this.feuxPosition = feuxPosition;
	}

	public boolean isEclairageImmatriculation() {
		return eclairageImmatriculation;
	}

	public void setEclairageImmatriculation(boolean eclairageImmatriculation) {
		this.eclairageImmatriculation = eclairageImmatriculation;
	}

	public boolean isFeuxCroisement() {
		return feuxCroisement;
	}

	public void setFeuxCroisement(boolean feuxCroisement) {
		this.feuxCroisement = feuxCroisement;
	}

	public boolean isFeuxRoute() {
		return feuxRoute;
	}

	public void setFeuxRoute(boolean feuxRoute) {
		this.feuxRoute = feuxRoute;
	}

	public boolean isFeuxJour() {
		return feuxJour;
	}

	public void setFeuxJour(boolean feuxJour) {
		this.feuxJour = feuxJour;
	}

	public boolean isFeuxDetresse() {
		return feuxDetresse;
	}

	public void setFeuxDetresse(boolean feuxDetresse) {
		this.feuxDetresse = feuxDetresse;
	}

	public boolean isFeuxStop() {
		return feuxStop;
	}

	public void setFeuxStop(boolean feuxStop) {
		this.feuxStop = feuxStop;
	}

	public boolean isFeuxAntiBrouillard() {
		return feuxAntiBrouillard;
	}

	public void setFeuxAntiBrouillard(boolean feuxAntiBrouillard) {
		this.feuxAntiBrouillard = feuxAntiBrouillard;
	}

	public boolean isFeuxRecul() {
		return feuxRecul;
	}

	public void setFeuxRecul(boolean feuxRecul) {
		this.feuxRecul = feuxRecul;
	}

	@Override
	public String toString() {
		return "Eclairage [id=" + id + ", feuxPosition=" + feuxPosition + ", eclairageImmatriculation="
				+ eclairageImmatriculation + ", feuxCroisement=" + feuxCroisement + ", feuxRoute=" + feuxRoute
				+ ", feuxJour=" + feuxJour + ", feuxDetresse=" + feuxDetresse + ", feuxStop=" + feuxStop
				+ ", feuxAntiBrouillard=" + feuxAntiBrouillard + ", feuxRecul=" + feuxRecul + "]";
	}

}
