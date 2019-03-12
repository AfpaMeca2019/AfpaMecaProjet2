package fr.afpa.formation.mecanique.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.mecanique.persistence.entity.or.Fournisseur;
import fr.afpa.formation.mecanique.persistence.repository.FournisseurRepository;

@Service
public class FournisseurService {
	
	@Autowired
	FournisseurRepository fr;
	
	public void createFournisseur(Fournisseur f) {
		fr.save(f);
	}
	
	public List<Fournisseur> findAll(){
		return (List<Fournisseur>) fr.findAll();
	}

}
