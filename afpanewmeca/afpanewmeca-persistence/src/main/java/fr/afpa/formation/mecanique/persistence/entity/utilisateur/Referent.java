package fr.afpa.formation.mecanique.persistence.entity.utilisateur;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "REF") //petit-enfant
public class Referent extends Formateur {

	/**
	 * <b>CONSTRUCTEUR SANS ARGUMENT</b>
	 */
	public Referent() {
		super();
	}

	/**
	 * <b>CONSTRUCTEUR AVEC LES ARGUMENTS SUIVANTS :</b><br/>
	 * TOUS LES ATTRIBUTS Y COMPRIS L'ID.<br/>
	 * (UTILISE LORS DES OPERATIONS DE RECHERCHE ET D'EXTRACTION 'findBy'). <br/>
	 */
	public Referent(Long id, String nom, String prenom, String telephone, String mail, String identifiant,
			String motDePasse, String role, Date inscription, Date radiation) {
		super(id, nom, prenom, telephone, mail, identifiant, motDePasse, role, inscription, radiation);

	}

	/**
	 * <b>CONSTRUCTEUR AVEC LES ARGUMENTS SUIVANTS :</b><br/>
	 * TOUS LES ATTRIBUTS SAUF L'ID.<br/>
	 * (UTILISE LORS DES OPERATIONS DE CREATION 'create'). <br/>
	 */
	public Referent(String nom, String prenom, String telephone, String mail, String identifiant, String motDePasse,
			String role, Date inscription, Date radiation) {
		super(nom, prenom, telephone, mail, identifiant, motDePasse, role, inscription, radiation);

	}

	@Override
	public String toString() {
		return "Referent [" + super.toString() + "]";
	}

}
