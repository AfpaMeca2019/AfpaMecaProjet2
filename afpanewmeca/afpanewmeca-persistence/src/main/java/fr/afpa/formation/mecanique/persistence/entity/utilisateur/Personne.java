package fr.afpa.formation.mecanique.persistence.entity.utilisateur;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Inheritance(strategy=InheritanceType.JOINED) //parent qui gère la stratégie des enfants et des grands enfants
@DiscriminatorColumn(name = "PERSONNE_TYPE", discriminatorType = DiscriminatorType.STRING, length = 3)//pour mettre tous les derivations possibles : enfants + grands enfants; pourla recherche pour ne pas parcourir toutes les tables-enfants, mais avoir le type de la table à parcourir directement
public abstract class Personne { // abstract = impossible de l'instancier , impossible de créer une personne sans avoir créer son "enfant" client ou utilisateur
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	public Long id;
	
	@Column(name = "nom", nullable = false, length = 50)
	public String nom;
	
	@Column(name = "prenom", nullable = false, length = 50)
	public String prenom;
	
	@Column(name = "telephone", length = 12)
	public String telephone;
	
	
	@Column(name = "mail", nullable = false, length = 50)
	private String mail;
	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * <b>CONSTRUCTEUR SANS ARGUMENT</b>
	 */
	public Personne() {
		
	}

	/**
	 * <b>CONSTRUCTEUR AVEC LES ARGUMENTS SUIVANTS :</b><br/>
	 * TOUS LES ATTRIBUTS Y COMPRIS L'ID.<br/>
	 * (UTILISE LORS DES OPERATIONS DE RECHERCHE ET D'EXTRACTION 'findBy'). <br/>
	 */
	public Personne(Long id, String nom, String prenom, String telephone, String mail) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.mail = mail;
	} //const-r d'extraction avec id
	
	/**
	 * <b>CONSTRUCTEUR AVEC LES ARGUMENTS SUIVANTS :</b><br/>
	 * TOUS LES ATTRIBUTS SAUF L'ID.<br/>
	 * (UTILISE LORS DES OPERATIONS DE CREATION 'create'). <br/>
	 */
	
	public Personne(String nom, String prenom, String telephone, String mail) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.mail = mail;
	} //constr-r de création sans id pour la crétaion d'un nouvel objet (au lieu de mettre null)

	
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", telephone=" + telephone + "]";
	}

	
	
}
