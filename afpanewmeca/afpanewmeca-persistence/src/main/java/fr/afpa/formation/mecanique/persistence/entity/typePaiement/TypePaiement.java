package fr.afpa.formation.mecanique.persistence.entity.typePaiement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class TypePaiement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;
	private String libellePaiement;

	public TypePaiement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibellePaiement() {
		return libellePaiement;
	}

	public void setLibellePaiement(String libellePaiement) {
		this.libellePaiement = libellePaiement;
	}

	public TypePaiement(String libellePaiement) {
		super();
		this.libellePaiement = libellePaiement;
	}

	@Override
	public String toString() {
		return "TypePaiement [id=" + id + ", libellePaiement=" + libellePaiement + "]";
	}

}
