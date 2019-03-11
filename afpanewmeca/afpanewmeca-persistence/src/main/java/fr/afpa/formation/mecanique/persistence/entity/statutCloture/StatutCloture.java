package fr.afpa.formation.mecanique.persistence.entity.statutCloture;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class StatutCloture {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;

	private String libelle;

	public StatutCloture() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getLibelle() {
		return libelle;
	}
}
