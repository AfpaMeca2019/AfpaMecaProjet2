package fr.afpa.formation.mecanique.persistence.entity.statutOR;

import javax.persistence.Entity;

@Entity
public class StatutValidationClient extends Statut_OR {
	
	public StatutValidationClient() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getStatut() {
		// TODO Auto-generated method stub
		return "Attente paiement client";
	}

}
