package fr.afpa.formation.mecanique.persistence.entity.or;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import fr.afpa.formation.mecanique.persistence.entity.statutCloture.StatutCloture;


@Entity
public class Cloture_OR {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;
	@ManyToOne
	private StatutCloture statutCloture;
	@OneToMany
	private Set<OrdreReparation> listOR = new HashSet<>();

	public Cloture_OR(StatutCloture statutCloture, OrdreReparation or) {
		super();
		this.statutCloture = statutCloture;
		listOR.add(or);
	}
	
	public Cloture_OR() {
		super();
	}

	public String getStatutCloture() {
		return statutCloture.getLibelle();
	}

	public void setStatutCloture(StatutCloture statutCloture) {
		this.statutCloture = statutCloture;
	}

}
