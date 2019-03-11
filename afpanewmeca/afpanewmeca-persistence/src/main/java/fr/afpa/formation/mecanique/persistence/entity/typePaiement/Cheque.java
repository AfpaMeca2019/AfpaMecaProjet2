package fr.afpa.formation.mecanique.persistence.entity.typePaiement;

import javax.persistence.Entity;

@Entity
public class Cheque extends TypePaiement {
	
	private static Cheque c = null;	
	private static String libelle = "Chèque";
	
	private Cheque() {}
	
	public Cheque getInstance() {
		if(c == null) {
			c = new Cheque();
		}
		return c;
	}

	public static String getLibelle() {
		return libelle;
	}
}
