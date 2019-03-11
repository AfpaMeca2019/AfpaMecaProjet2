package fr.afpa.formation.mecanique.persistence.entity.statutOR;

import javax.persistence.Entity;

@Entity
public class EnReparation extends Statut_OR {
	
	public EnReparation() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getStatut() {
		// TODO Auto-generated method stub
		return "En réparation";
	}

}
