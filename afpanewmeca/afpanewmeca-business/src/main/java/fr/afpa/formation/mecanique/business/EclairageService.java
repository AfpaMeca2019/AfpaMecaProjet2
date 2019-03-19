package fr.afpa.formation.mecanique.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.mecanique.persistence.entity.cq.Eclairage;
import fr.afpa.formation.mecanique.persistence.repository.EclairageRepository;

@Service
public class EclairageService {
	@Autowired
	EclairageRepository er;
	
	public void createEclairage(Eclairage e) {
		er.save(e);
	}
	
	public List<Eclairage> findAll(){
		return (List<Eclairage>) er.findAll();
	}
	
	public Eclairage findById(Long id) throws Exception {
		if (id == null) {
			throw new Exception("Eclairage findById: l'id est null");
		}

		Eclairage f = er.findById(id).get();

		if (f == null) {
			throw new Exception("Eclairage findById: le Eclairage est null");
		}

		return f;
	}

}
