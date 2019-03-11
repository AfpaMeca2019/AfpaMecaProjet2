package fr.afpa.formation.mecanique.persistence.entity.utilisateur;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
@DiscriminatorValue(value = "CLI")
public class Client extends Personne {

	@Column(name = "numero", nullable = false, length = 30, unique = true)
	private String numero;
	
	@Column(unique = true, length = 25)
	private String numeroCarteAfpa;
	
	@Column(name = "dateInscription", nullable=false)
	private Date dateInscription;

	@Column(name = "statut", nullable = false)
	private boolean statut;
	
	@ManyToOne
	private Adresse adresse;
	
	@OneToMany
	private Set<Vehicule> listVehicule = new HashSet<>();

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	/**
	 * <b>CONSTRUCTEUR SANS ARGUMENT</b>
	 */
	public Client() {
		super();
	}
	
	/**
	 * <b>CONSTRUCTEUR AVEC LES ARGUMENTS SUIVANTS :</b><br/>
	 * TOUS LES ATTRIBUTS Y COMPRIS L'ID.<br/>
	 * (UTILISE LORS DES OPERATIONS DE RECHERCHE ET D'EXTRACTION 'findBy'). <br/>
	 */
	public Client(Long id, String nom, String prenom, String telephone, String mail, 
			String numero, String numeroCarteAfpa, Date dateInscription, boolean statut) {
		super(id, nom, prenom, telephone, mail);
		this.numero = numero;
		this.numeroCarteAfpa = numeroCarteAfpa;
		this.dateInscription = dateInscription;
		this.statut = statut;
		
	} //super + constr-r (avec id)
	
	

	/**
	 * <b>CONSTRUCTEUR AVEC LES ARGUMENTS SUIVANTS :</b><br/>
	 * TOUS LES ATTRIBUTS SAUF L'ID.<br/>
	 * (UTILISE LORS DES OPERATIONS DE CREATION 'create'). <br/>
	 */
	public Client(String nom, String prenom, String telephone, String mail,
			String numero, String numeroCarteAfpa, Date dateInscription, boolean statut) {
		super(nom, prenom, telephone, mail);
		this.numero = numero;
		this.numeroCarteAfpa = numeroCarteAfpa;
		this.dateInscription = dateInscription;
		this.statut = statut;
		
	}


	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	public boolean getStatut() {
		return statut;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}

	public String getNumeroCarteAfpa() {
		return numeroCarteAfpa;
	}

	public void setNumeroCarteAfpa(String numeroCarteAfpa) {
		this.numeroCarteAfpa = numeroCarteAfpa;
	}
	
	

	public Set<Vehicule> getListVehicule() {
		return listVehicule;
	}

	public void setListVehicule(Set<Vehicule> listVehicule) {
		this.listVehicule = listVehicule;
	}

	@Override
	public String toString() {
		return "Client [numero=" + numero + ", numeroCarteAfpa=" + numeroCarteAfpa + ", dateInscription="
				+ dateInscription + ", statut=" + statut + ", id=" + id + ", nom=" + nom + ", prenom=" + prenom
				+ ", telephone=" + telephone + "]";
	}

	

}
