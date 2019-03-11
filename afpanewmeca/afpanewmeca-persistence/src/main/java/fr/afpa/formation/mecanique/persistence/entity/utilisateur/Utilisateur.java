package fr.afpa.formation.mecanique.persistence.entity.utilisateur;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity //on ne met pas ni Inheritance, ni DiscriminatorColumn, car ca va dans la grand-père Personne
public abstract class Utilisateur extends Personne { //abstract, car s'est une classe parent, qui aura 3 classes-enfants

	@Column(name = "identifiant", nullable = false, length = 50, unique = true, insertable=false, updatable=false)
	private String identifiant; // login

	@Column(name = "motDePasse", nullable = false, length = 25)
	private String motDePasse;

	@Column(name = "role", nullable = false, length = 10)
	private String role;

	@Column(name = "identifiant", nullable = false)
	private Date inscription;

	@Column(name = "radiation")
	private Date radiation;

	/**
	 * <b>CONSTRUCTEUR SANS ARGUMENT</b>
	 */
	public Utilisateur() {
		super();
	}

	/**
	 * <b>CONSTRUCTEUR AVEC LES ARGUMENTS SUIVANTS :</b><br/>
	 * TOUS LES ATTRIBUTS Y COMPRIS L'ID.<br/>
	 * (UTILISE LORS DES OPERATIONS DE RECHERCHE ET D'EXTRACTION 'findBy'). <br/>
	 */
	public Utilisateur(Long id, String nom, String prenom, String telephone, String mail, String identifiant,
			String motDePasse, String role, Date inscription, Date radiation) {
		super(id, nom, prenom, telephone, mail);
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
		this.role = role;
		this.inscription = inscription;
		this.radiation = radiation;
	} // const-r- d'extraction

	/**
	 * <b>CONSTRUCTEUR AVEC LES ARGUMENTS SUIVANTS :</b><br/>
	 * TOUS LES ATTRIBUTS SAUF L'ID.<br/>
	 * (UTILISE LORS DES OPERATIONS DE CREATION 'create'). <br/>
	 */

	public Utilisateur(String nom, String prenom, String telephone, String mail, String identifiant, String motDePasse,
			String role, Date inscription, Date radiation) {
		super(nom, prenom, telephone, mail);
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
		this.role = role;
		this.inscription = inscription;
		this.radiation = radiation;
	} // constr-r de création sans id

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getInscription() {
		return inscription;
	}

	public void setInscription(Date inscription) {
		this.inscription = inscription;
	}

	public Date getRadiation() {
		return radiation;
	}

	public void setRadiation(Date radiation) {
		this.radiation = radiation;
	}

	@Override
	public String toString() {
		return "Utilisateur [identifiant=" + identifiant + ", motDePasse=" + motDePasse + ", role=" + role
				+ ", inscription=" + inscription + ", radiation=" + radiation + "]";
	}

}
