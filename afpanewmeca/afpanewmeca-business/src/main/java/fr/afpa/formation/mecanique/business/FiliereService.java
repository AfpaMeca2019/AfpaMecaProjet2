package fr.afpa.formation.mecanique.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.mecanique.persistence.entity.utilisateur.Filiere;
import fr.afpa.formation.mecanique.persistence.repository.FiliereRepository;

@Service
public class FiliereService {

	@Autowired
	FiliereRepository fr;
	
	public void createFiliere(Filiere f) {
		fr.save(f);
	}
	
	public List<Filiere> findAll(){
		return (List<Filiere>) fr.findAll();
	}
}
