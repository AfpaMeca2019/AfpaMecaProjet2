package fr.afpa.formation.mecanique.persistence.entity.statutCloture;

import javax.persistence.Entity;


@Entity
public class RefusClient extends StatutCloture {
	private static String libelle = "Refus client";
	
	public RefusClient() {
		// TODO Auto-generated constructor stub
		super();
	}

	public String getLibelle() {
		return libelle;
	}

}
