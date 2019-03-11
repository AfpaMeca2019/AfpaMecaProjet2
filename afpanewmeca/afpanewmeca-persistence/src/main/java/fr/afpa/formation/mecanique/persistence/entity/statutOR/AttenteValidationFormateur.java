package fr.afpa.formation.mecanique.persistence.entity.statutOR;

import javax.persistence.Entity;

@Entity
public class AttenteValidationFormateur extends Statut_OR {
	
	public AttenteValidationFormateur() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getStatut() {
		// TODO Auto-generated method stub
		return "Attente validation formateur";
	}

}
