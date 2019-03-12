package fr.afpa.formation.mecanique.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.mecanique.persistence.entity.typePaiement.TypePaiement;
import fr.afpa.formation.mecanique.persistence.repository.TypePaiementRepository;

@Service
public class TypePaiementService {
	@Autowired
	TypePaiementRepository tpr;
	
	public void createTypePaiement(TypePaiement tp) {
		tpr.save(tp);
	}

}
