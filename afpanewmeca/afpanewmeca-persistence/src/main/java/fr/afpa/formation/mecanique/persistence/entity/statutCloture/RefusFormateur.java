package fr.afpa.formation.mecanique.persistence.entity.statutCloture;

import javax.persistence.Entity;


@Entity
public class RefusFormateur extends StatutCloture {
	private static String libelle = "Refus formateur";

	public RefusFormateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getLibelle() {
		return libelle;
	}

}
