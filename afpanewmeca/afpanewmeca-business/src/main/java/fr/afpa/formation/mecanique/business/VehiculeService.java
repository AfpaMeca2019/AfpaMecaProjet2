package fr.afpa.formation.mecanique.business;

import java.util.List;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.mecanique.persistence.entity.utilisateur.Vehicule;
import fr.afpa.formation.mecanique.persistence.repository.VehiculeRepository;

@Service
public class VehiculeService {

	
	@Autowired
	VehiculeRepository vehiculeRepository;
	
	public List<Vehicule> findAll(){
		return (List<Vehicule>) vehiculeRepository.findAll();
	}



	public Vehicule create(Vehicule v) throws Exception {
		if (v == null) {
			throw new Exception();
		}

		if (v.getId() != null) {
			Optional<Vehicule> vOptional = vehiculeRepository.findById(v.getId());

			if (vOptional.isPresent()) {
				throw new Exception();
			} else {
				throw new Exception();
			}
		}

		return vehiculeRepository.save(v);

	}
}

