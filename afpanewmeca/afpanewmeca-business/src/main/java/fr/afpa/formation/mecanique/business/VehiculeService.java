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

	public List<Vehicule> findAll() throws Exception {
		List<Vehicule> findAll = (List<Vehicule>) vehiculeRepository.findAll();

		if ((findAll == null)) {
			throw new Exception("Véhicule List exception: la liste est nulle");
		}

		return findAll;
	}

	public Vehicule findById(Long id) throws Exception {
		if (id == null) {
			throw new Exception("Vehicule findById: l'id est null");
		}

		Vehicule v = vehiculeRepository.findById(id).get();

		if (v == null) {
			throw new Exception("Vehicule findById: le véhicule est null");
		}

		return v;
	}

	public Vehicule create(Vehicule v) throws Exception {
		if (v == null) {
			throw new Exception("Creation véhicule exception: le vehicule est null");
		}

		if (v.getId() != null) {
			Optional<Vehicule> vOptional = vehiculeRepository.findById(v.getId());

			if (vOptional.isPresent()) {
				throw new Exception("Creation véhicule exception: le vehicule existe déjà");
			} else {
				throw new Exception("Creation véhicule exception: l'id n'est pas null");
			}
		}

		return vehiculeRepository.save(v);

	}

	public Vehicule update (Vehicule v) throws Exception {
		if ((v == null) || (v.getId() == null)) {
			throw new Exception("Vehicule update : le véhicule est null ou son id est null");
		}

		Long idAChercher = v.getId();
		Optional<Vehicule> vehiculeOptional = vehiculeRepository.findById(idAChercher);

		if (!vehiculeOptional.isPresent()) {
			throw new Exception("Vehicule update : le vehicule n'a pas été trouvé");
		}
		return vehiculeRepository.save(v);
	}
	
	public void deleteById(Long id) throws Exception {
		if (id == null) {
			throw new Exception("Véhicule delete by id: l'id est null");
		}

		Optional<Vehicule> vehiculeOptional = vehiculeRepository.findById(id);
		if (!vehiculeOptional.isPresent()) {
			throw new Exception("Vehicule with requested id does not exist");
		}

		vehiculeRepository.deleteById(id);
	}
}

