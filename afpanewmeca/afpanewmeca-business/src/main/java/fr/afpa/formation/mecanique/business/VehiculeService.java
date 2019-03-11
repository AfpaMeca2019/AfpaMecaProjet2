package fr.afpa.formation.mecanique.business;

import java.util.List;

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
}
