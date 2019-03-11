package fr.afpa.formation.mecanique.persistence.entity.statutOR;

import javax.persistence.Entity;

@Entity
public class DemandeCloture extends Statut_OR {
	
	public DemandeCloture() {}

	@Override
	public String getStatut() {
		// TODO Auto-generated method stub
		return "Demande de clôture";
	}

}
