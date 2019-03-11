package fr.afpa.formation.mecanique.persistence.entity.or;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.hibernate.annotations.GenericGenerator;

import fr.afpa.formation.mecanique.persistence.entity.cq.ControleQualite;
import fr.afpa.formation.mecanique.persistence.entity.statutOR.Statut_OR;
import fr.afpa.formation.mecanique.persistence.entity.utilisateur.Utilisateur;


@Entity
public class OrdreReparation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(nullable = false)
	private String numeroOR;
	@Column(nullable = false)
	private java.util.Date dateCreation;
	private java.util.Date dateSortie;
	@Column(nullable = false)
	private String symptomesClient;
	@Column(nullable = false)
	private String interventionsARealiser;
	private String interventionsRealisees;
	private String futursTravaux;
	@OneToMany
	private Set<Devis> listDevis = new HashSet<>();
	@OneToOne
	private ControleQualite cq;
	@OneToOne
	private Cloture_OR clotureor;
	@ManyToOne
	private Statut_OR statutor;
	@OneToOne
	private Utilisateur userCreate;
	@OneToOne
	private Utilisateur userValid;
	@OneToOne
	private Utilisateur userCloture;

	public OrdreReparation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrdreReparation(String numeroOR, Date dateCreation, String symptomesClient, String interventionsARealiser) {
		super();
		this.numeroOR = numeroOR;
		this.dateCreation = dateCreation;
		this.symptomesClient = symptomesClient;
		this.interventionsARealiser = interventionsARealiser;
	}

	public void addDevis(Devis d) {
		listDevis.add(d);
	}

	public String getNumeroOR() {
		return numeroOR;
	}

	public void setNumeroOR(String numeroOR) {
		this.numeroOR = numeroOR;
	}

	public java.util.Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(java.util.Date date) {
		this.dateCreation = date;
	}

	public java.util.Date getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(java.util.Date date) {
		this.dateSortie = date;
	}

	public String getSymptomesClient() {
		return symptomesClient;
	}

	public void setSymptomesClient(String symptomesClient) {
		this.symptomesClient = symptomesClient;
	}

	public String getInterventionsARealiser() {
		return interventionsARealiser;
	}

	public void setInterventionsARealiser(String interventionsARealiser) {
		this.interventionsARealiser = interventionsARealiser;
	}

	public String getInterventionsRealisees() {
		return interventionsRealisees;
	}

	public void setInterventionsRealisees(String interventionsRealisees) {
		this.interventionsRealisees = interventionsRealisees;
	}

	public String getFutursTravaux() {
		return futursTravaux;
	}

	public void setFutursTravaux(String futursTravaux) {
		this.futursTravaux = futursTravaux;
	}

	public Cloture_OR getClotureor() {
		return clotureor;
	}

	public void setClotureor(Cloture_OR clotureor) {
		this.clotureor = clotureor;
	}

	public Statut_OR getStatutor() {
		return statutor;
	}

	public void setStatutor(Statut_OR statutor) {
		this.statutor = statutor;
	}
}