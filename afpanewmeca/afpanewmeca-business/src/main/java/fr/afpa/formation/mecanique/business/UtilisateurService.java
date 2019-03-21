package fr.afpa.formation.mecanique.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.mecanique.persistence.entity.utilisateur.Utilisateur;
import fr.afpa.formation.mecanique.persistence.repository.UtilisateurRepository;

@Service
public class UtilisateurService {
	@Autowired
	private UtilisateurRepository ur;
	
	public List<Utilisateur> findByIdentifiant(String id) {
		return ur.findByIdentifiant(id);
	}

}
