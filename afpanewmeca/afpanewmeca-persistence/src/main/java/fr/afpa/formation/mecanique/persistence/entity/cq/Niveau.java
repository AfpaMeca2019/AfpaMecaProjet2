package fr.afpa.formation.mecanique.persistence.entity.cq;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Niveau {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;
	private boolean liquideRefroidissement;
	private boolean laveGlace;
	private boolean huileMoteur;
	private boolean liquideFrein;
	private boolean huileDirectionAssistee;

	public Niveau(boolean liquideRefroidissement, boolean laveGlace, boolean huileMoteur, boolean liquideFrein,
			boolean huileDirectionAssistee) {
		super();
		this.liquideRefroidissement = liquideRefroidissement;
		this.laveGlace = laveGlace;
		this.huileMoteur = huileMoteur;
		this.liquideFrein = liquideFrein;
		this.huileDirectionAssistee = huileDirectionAssistee;
	}

	public Niveau() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isLiquideRefroidissement() {
		return liquideRefroidissement;
	}

	public void setLiquideRefroidissement(boolean liquideRefroidissement) {
		this.liquideRefroidissement = liquideRefroidissement;
	}

	public boolean isLaveGlace() {
		return laveGlace;
	}

	public void setLaveGlace(boolean laveGlace) {
		this.laveGlace = laveGlace;
	}

	public boolean isHuileMoteur() {
		return huileMoteur;
	}

	public void setHuileMoteur(boolean huileMoteur) {
		this.huileMoteur = huileMoteur;
	}

	public boolean isLiquideFrein() {
		return liquideFrein;
	}

	public void setLiquideFrein(boolean liquideFrein) {
		this.liquideFrein = liquideFrein;
	}

	public boolean isHuileDirectionAssistee() {
		return huileDirectionAssistee;
	}

	public void setHuileDirectionAssistee(boolean huileDirectionAssistee) {
		this.huileDirectionAssistee = huileDirectionAssistee;
	}

	@Override
	public String toString() {
		return "Niveau [id=" + id + ", liquideRefroidissement=" + liquideRefroidissement + ", laveGlace=" + laveGlace
				+ ", huileMoteur=" + huileMoteur + ", liquideFrein=" + liquideFrein + ", huileDirectionAssistee="
				+ huileDirectionAssistee + "]";
	}

}
