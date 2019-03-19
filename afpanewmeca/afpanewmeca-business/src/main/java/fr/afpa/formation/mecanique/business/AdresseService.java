package fr.afpa.formation.mecanique.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.mecanique.persistence.entity.utilisateur.Adresse;
import fr.afpa.formation.mecanique.persistence.entity.utilisateur.Vehicule;
import fr.afpa.formation.mecanique.persistence.repository.AdresseRepository;

@Service
public class AdresseService {

	@Autowired
	AdresseRepository adresseRepo;

	public List<Adresse> findAll() {
		return  (List<Adresse>) adresseRepo.findAll();
		
		
	}

	public Adresse create(Adresse adresse) throws Exception {
		if (adresse == null) {
			throw new Exception();
		}

		if (adresse.getId() != null) {
			Optional<Adresse> aOptional = adresseRepo.findById(adresse.getId());

			if (aOptional.isPresent()) {
				throw new Exception();
			} else {
				throw new Exception();
			}
		}

		return adresseRepo.save(adresse);

	}
}
