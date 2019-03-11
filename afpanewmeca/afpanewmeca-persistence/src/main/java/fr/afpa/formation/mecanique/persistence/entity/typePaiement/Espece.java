package fr.afpa.formation.mecanique.persistence.entity.typePaiement;

import javax.persistence.Entity;

@Entity
public class Espece extends TypePaiement {
	private static Espece e = null;
	private static String libelle = "Espece";
	
	private Espece() {}
	
	public Espece getInstance() {
		if(e == null) {
			e = new Espece();
		}
		return e;
	}

	public static String getLibelle() {
		return libelle;
	}
}
