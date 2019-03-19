package fr.afpa.formation.mecanique.persistence.entity.or;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import fr.afpa.formation.mecanique.persistence.entity.typePaiement.TypePaiement;


@Entity
@Table(name="devis")
public class Devis {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;
	private Date dateCreation;
	private String numDevis;
	private Date datePaiement;
	@OneToMany
	private Set<DevisItem> listDevisItem = new HashSet<>();
	@ManyToOne
	private TypePaiement typePaiement;
	@ManyToOne
	private Fournisseur fournisseur;

	public Devis(Date dateCreation, String numDevis, Date datePaiement, TypePaiement typePaiement, Fournisseur fournisseur) {
		super();
		this.dateCreation = dateCreation;
		this.numDevis = numDevis;
		this.datePaiement = datePaiement;
		this.typePaiement = typePaiement;
		this.fournisseur = fournisseur;
	}
	
	public void addDevisItem(DevisItem di) {
		listDevisItem.add(di);
	}

	public Devis() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getNumDevis() {
		return numDevis;
	}

	public void setNumDevis(String numDevis) {
		this.numDevis = numDevis;
	}

	public Date getDatePaiement() {
		return datePaiement;
	}

	public void setDatePaiement(Date datePaiement) {
		this.datePaiement = datePaiement;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<DevisItem> getListDevisItem() {
		return listDevisItem;
	}

	public void setListDevisItem(Set<DevisItem> listDevisItem) {
		this.listDevisItem = listDevisItem;
	}

	public TypePaiement getTypePaiement() {
		return typePaiement;
	}

	public void setTypePaiement(TypePaiement typePaiement) {
		this.typePaiement = typePaiement;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	@Override
	public String toString() {
		return "Devis [id=" + id + ", dateCreation=" + dateCreation + ", numDevis=" + numDevis + ", datePaiement="
				+ datePaiement + ", listDevisItem=" + listDevisItem + ", typePaiement=" + typePaiement.toString()
				+ ", fournisseur=" + fournisseur.toString() + "]";
	}



}
