package fr.afpa.formation.mecanique.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.mecanique.persistence.entity.utilisateur.Formateur;
import fr.afpa.formation.mecanique.persistence.repository.FormateurRepository;

@Service
public class FormateurService {
	@Autowired
	FormateurRepository fr;
	
	public void createFormateur(Formateur f) {
		fr.save(f);
	}
	
	public List<Formateur> findAll(){
		return (List<Formateur>) fr.findAll();
	}

}
