package fr.afpa.formation.mecanique.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.mecanique.persistence.entity.cq.ControleQualite;
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

}
