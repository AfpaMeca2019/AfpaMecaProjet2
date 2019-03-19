package fr.afpa.formation.mecanique.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.mecanique.persistence.entity.utilisateur.Stagiaire;
import fr.afpa.formation.mecanique.persistence.repository.StagiaireRepository;

@Service
public class StagiaireService {
	@Autowired
	StagiaireRepository fr;
	
	public void createStagiare(Stagiaire f) {
		fr.save(f);
	}
	
	public List<Stagiaire> findAll(){
		return (List<Stagiaire>) fr.findAll();
	}
}