package fr.afpa.formation.mecanique.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.mecanique.persistence.entity.utilisateur.Stagiaire;
import fr.afpa.formation.mecanique.persistence.repository.StagiaireRepository;

@Service
public class StagiaireService {
	@Autowired
	StagiaireRepository stagiaireRepository;
	
	public void createStagiare(Stagiaire f) {
		stagiaireRepository.save(f);
	}
	
	public List<Stagiaire> findAll(){
		return (List<Stagiaire>) stagiaireRepository.findAll();
	}
	
	public List<Stagiaire> findByCarte(String carte) {
		return stagiaireRepository.findByCarteAfpa(carte);
	}
	
	public List<Stagiaire> findByFiliere(String f){
		return stagiaireRepository.findByFiliere(f);
	}
	
	public Stagiaire update(Stagiaire stagiaire) throws Exception {
		if ((stagiaire == null) || (stagiaire.getId() == null)) {
			throw new Exception("Le stagiaire est null ou son id est null");
		}

		Long idAChercher = stagiaire.getId();
		Optional<Stagiaire> stagiaireOptional = stagiaireRepository.findById(idAChercher);

		if (!stagiaireOptional.isPresent()) {
			throw new Exception("Le stagiaire n'a pas été trouvé");
		}
		return stagiaireRepository.save(stagiaire);
	}
	
	
	public void deleteById(Long id) throws Exception {
		if (id == null) {
			throw new Exception("Id est null");
		}

		Optional<Stagiaire> stagiaireOptional = stagiaireRepository.findById(id);
		if (!stagiaireOptional.isPresent()) {
			throw new Exception("Stagiaire n'existe pas");
		}

		stagiaireRepository.deleteById(id);
	}
	
	
}
