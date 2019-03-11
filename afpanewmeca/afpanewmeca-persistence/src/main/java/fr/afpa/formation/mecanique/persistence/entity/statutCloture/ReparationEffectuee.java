package fr.afpa.formation.mecanique.persistence.entity.statutCloture;

import javax.persistence.Entity;

@Entity
public class ReparationEffectuee extends StatutCloture {
	private static String libelle = "Réparation effectuée";

	public ReparationEffectuee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getLibelle() {
		return libelle;
	}

}
