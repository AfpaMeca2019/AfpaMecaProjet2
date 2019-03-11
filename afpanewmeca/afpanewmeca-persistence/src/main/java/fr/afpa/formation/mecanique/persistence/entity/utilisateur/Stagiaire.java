package fr.afpa.formation.mecanique.persistence.entity.utilisateur;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import fr.afpa.formation.mecanique.persistence.entity.utilisateur.Utilisateur;

@Entity
@DiscriminatorValue(value = "STA")//petit enfant
public class Stagiaire extends Utilisateur {

	@Column(name = "numeroCarteAfpa", nullable = false, length = 30, unique = true)
	public String numeroCarteAfpa;

	/**
	 * <b>CONSTRUCTEUR SANS ARGUMENT</b>
	 */
	public Stagiaire() {
		super();
	}

	/**
	 * <b>CONSTRUCTEUR AVEC LES ARGUMENTS SUIVANTS :</b><br/>
	 * TOUS LES ATTRIBUTS Y COMPRIS L'ID.<br/>
	 * (UTILISE LORS DES OPERATIONS DE RECHERCHE ET D'EXTRACTION 'findBy'). <br/>
	 */
	public Stagiaire(Long id, String nom, String prenom, String telephone, String mail, String identifiant,
			String motDePasse, String role, Date inscription, Date radiation, String numeroCarteAfpa) {
		super(id, nom, prenom, telephone, mail, identifiant, motDePasse, role, inscription, radiation);
		this.numeroCarteAfpa = numeroCarteAfpa;
	}

	/**
	 * <b>CONSTRUCTEUR AVEC LES ARGUMENTS SUIVANTS :</b><br/>
	 * TOUS LES ATTRIBUTS SAUF L'ID.<br/>
	 * (UTILISE LORS DES OPERATIONS DE CREATION 'create'). <br/>
	 */
	public Stagiaire(String nom, String prenom, String telephone, String mail, String identifiant, String motDePasse,
			String role, Date inscription, Date radiation, String numeroCarteAfpa) {
		super(nom, prenom, telephone, mail, identifiant, motDePasse, role, inscription, radiation);
		this.numeroCarteAfpa = numeroCarteAfpa;
	}

	public String getNumeroCarteAfpa() {
		return numeroCarteAfpa;
	}

	public void setNumeroCarteAfpa(String numeroCarteAfpa) {
		this.numeroCarteAfpa = numeroCarteAfpa;
	}

	@Override
	public String toString() {
		return "Formateur [ " + super.toString() + "numeroCarteAfpa=" + numeroCarteAfpa + "]";
	}
	
}
