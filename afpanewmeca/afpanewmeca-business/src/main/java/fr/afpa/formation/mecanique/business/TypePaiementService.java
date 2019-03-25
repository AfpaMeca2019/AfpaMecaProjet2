package fr.afpa.formation.mecanique.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.mecanique.persistence.entity.or.Fournisseur;
import fr.afpa.formation.mecanique.persistence.entity.typePaiement.TypePaiement;
import fr.afpa.formation.mecanique.persistence.repository.TypePaiementRepository;

@Service
public class TypePaiementService {
	@Autowired
	TypePaiementRepository tpr;
	
	public void createTypePaiement(TypePaiement tp) {
		tpr.save(tp);
	}

	public List<TypePaiement> findAll() throws Exception {
		List<TypePaiement> findAll = (List<TypePaiement>) tpr.findAll();

		if ((findAll == null)) {
			throw new Exception("TypePaiement List exception: la liste est nulle");
		}

		return findAll;
	}
	
	
	public TypePaiement findById(Long id) throws Exception {
		if (id == null) {
			throw new Exception("TypePaiement findById: l'id est null");
		}

		TypePaiement typePaiement = tpr.findById(id).get();

		if (typePaiement == null) {
			throw new Exception("TypePaiement findById: le TypePaiement est null");
		}

		return typePaiement;
	}

}
