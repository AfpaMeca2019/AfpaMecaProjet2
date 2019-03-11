package fr.afpa.formation.mecanique.persistence.entity.statutOR;

import javax.persistence.Entity;

@Entity
public class Cloture extends Statut_OR {
	
	public Cloture() {}

	@Override
	public String getStatut() {
		// TODO Auto-generated method stub
		return "Clôturé";
	}
}