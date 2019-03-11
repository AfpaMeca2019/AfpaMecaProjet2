package fr.afpa.formation.mecanique.persistence.entity.cq;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Pneumatique {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;
	private int etatPneuAvGauche;
	private int etatPneuAvDroit;
	private int etatPneuArGauche;
	private int etatPneuArDroite;
	private int etatPneuSecours;
	private int pressionPneuAvGauche;
	private int pressionPneuArGauche;
	private int pressionPneuAvDroite;
	private int pressionPneuArDroite;

	public Pneumatique(int etatPneuAvGauche, int etatPneuAvDroit, int etatPneuArGauche, int etatPneuArDroite,
			int etatPneuSecours, int pressionPneuAvGauche, int pressionPneuArGauche, int pressionPneuAvDroite,
			int pressionPneuArDroite) {
		super();
		this.etatPneuAvGauche = etatPneuAvGauche;
		this.etatPneuAvDroit = etatPneuAvDroit;
		this.etatPneuArGauche = etatPneuArGauche;
		this.etatPneuArDroite = etatPneuArDroite;
		this.etatPneuSecours = etatPneuSecours;
		this.pressionPneuAvGauche = pressionPneuAvGauche;
		this.pressionPneuArGauche = pressionPneuArGauche;
		this.pressionPneuAvDroite = pressionPneuAvDroite;
		this.pressionPneuArDroite = pressionPneuArDroite;
	}

	public Pneumatique() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getEtatPneuAvGauche() {
		return etatPneuAvGauche;
	}

	public void setEtatPneuAvGauche(int etatPneuAvGauche) {
		this.etatPneuAvGauche = etatPneuAvGauche;
	}

	public int getEtatPneuAvDroit() {
		return etatPneuAvDroit;
	}

	public void setEtatPneuAvDroit(int etatPneuAvDroit) {
		this.etatPneuAvDroit = etatPneuAvDroit;
	}

	public int getEtatPneuArGauche() {
		return etatPneuArGauche;
	}

	public void setEtatPneuArGauche(int etatPneuArGauche) {
		this.etatPneuArGauche = etatPneuArGauche;
	}

	public int getEtatPneuArDroite() {
		return etatPneuArDroite;
	}

	public void setEtatPneuArDroite(int etatPneuArDroite) {
		this.etatPneuArDroite = etatPneuArDroite;
	}

	public int getEtatPneuSecours() {
		return etatPneuSecours;
	}

	public void setEtatPneuSecours(int etatPneuSecours) {
		this.etatPneuSecours = etatPneuSecours;
	}

	public int getPressionPneuAvGauche() {
		return pressionPneuAvGauche;
	}

	public void setPressionPneuAvGauche(int pressionPneuAvGauche) {
		this.pressionPneuAvGauche = pressionPneuAvGauche;
	}

	public int getPressionPneuArGauche() {
		return pressionPneuArGauche;
	}

	public void setPressionPneuArGauche(int pressionPneuArGauche) {
		this.pressionPneuArGauche = pressionPneuArGauche;
	}

	public int getPressionPneuAvDroite() {
		return pressionPneuAvDroite;
	}

	public void setPressionPneuAvDroite(int pressionPneuAvDroite) {
		this.pressionPneuAvDroite = pressionPneuAvDroite;
	}

	public int getPressionPneuArDroite() {
		return pressionPneuArDroite;
	}

	public void setPressionPneuArDroite(int pressionPneuArDroite) {
		this.pressionPneuArDroite = pressionPneuArDroite;
	}

	@Override
	public String toString() {
		return "Pneumatique [id=" + id + ", etatPneuAvGauche=" + etatPneuAvGauche + ", etatPneuAvDroit="
				+ etatPneuAvDroit + ", etatPneuArGauche=" + etatPneuArGauche + ", etatPneuArDroite=" + etatPneuArDroite
				+ ", etatPneuSecours=" + etatPneuSecours + ", pressionPneuAvGauche=" + pressionPneuAvGauche
				+ ", pressionPneuArGauche=" + pressionPneuArGauche + ", pressionPneuAvDroite=" + pressionPneuAvDroite
				+ ", pressionPneuArDroite=" + pressionPneuArDroite + "]";
	}

}
