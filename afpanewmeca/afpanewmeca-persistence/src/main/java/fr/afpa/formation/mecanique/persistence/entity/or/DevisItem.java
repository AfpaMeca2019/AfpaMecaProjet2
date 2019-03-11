package fr.afpa.formation.mecanique.persistence.entity.or;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "devisItem")
public class DevisItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;
	@OneToOne
	private Piece p;
	private int nbPiece;

	public DevisItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DevisItem(Piece p, int nbPiece) {
		super();
		this.p = p;
		this.nbPiece = nbPiece;
	}

	public Piece getP() {
		return p;
	}

	public void setP(Piece p) {
		this.p = p;
	}

	public int getNbPiece() {
		return nbPiece;
	}

	public void setNbPiece(int nbPiece) {
		this.nbPiece = nbPiece;
	}

}
