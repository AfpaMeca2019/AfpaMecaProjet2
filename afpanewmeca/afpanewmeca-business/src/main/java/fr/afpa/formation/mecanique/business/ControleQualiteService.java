package fr.afpa.formation.mecanique.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.mecanique.persistence.entity.cq.ControleQualite;
import fr.afpa.formation.mecanique.persistence.entity.utilisateur.Vehicule;
import fr.afpa.formation.mecanique.persistence.repository.ControleQualiteRepository;

@Service
public class ControleQualiteService {
	@Autowired
	ControleQualiteRepository cqr;
	
	public void createCQ(ControleQualite cq) {
		cqr.save(cq);
	}
	
	public List<ControleQualite> findAll(){
		return (List<ControleQualite>) cqr.findAll();
	}
	
	public ControleQualite update(ControleQualite cq) throws Exception {
		if(cq == null || cq.getId() == null) {
			throw new Exception("Contrôle qualité update : le controle qualité ou son id est null");
		}
		
		Long idAChercher = cq.getId();
		
		Optional<ControleQualite> cqCherche = cqr.findById(idAChercher);
		
		if(!cqCherche.isPresent()) {
			throw new Exception("Contrôle qualité update : le controle qualité n'a pas été trouvé");
		}
		
		return cqr.save(cq);
	}
	
	public ControleQualite findById(Long id) throws Exception {
		if (id == null) {
			throw new Exception("Contrôle qualité findById: l'id est null");
		}

		ControleQualite cq = cqr.findById(id).get();

		if (cq == null) {
			throw new Exception("Contrôle qualité findById: le véhicule est null");
		}

		return cq;
	}

}
