package fr.afpa.formation.mecanique.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.mecanique.persistence.entity.utilisateur.Referent;
import fr.afpa.formation.mecanique.persistence.repository.ReferentRepository;

@Service
public class ReferentService {
	@Autowired
	ReferentRepository rr;
	
	public void createReferent(Referent f) {
		rr.save(f);
	}
	
	public List<Referent> findAll(){
		return (List<Referent>) rr.findAll();
	}

}
