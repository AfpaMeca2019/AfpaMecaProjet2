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
	private TypePaiement paie;
	@ManyToOne
	private Fournisseur f;

	public Devis(Date dateCreation, String numDevis, Date datePaiement, TypePaiement tp, Fournisseur leF) {
		super();
		this.dateCreation = dateCreation;
		this.numDevis = numDevis;
		this.datePaiement = datePaiement;
		paie = tp;
		f = leF;
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

	public TypePaiement getPaie() {
		return paie;
	}

	public void setPaie(TypePaiement paie) {
		this.paie = paie;
	}

	public Fournisseur getF() {
		return f;
	}

	public void setF(Fournisseur f) {
		this.f = f;
	}

}
