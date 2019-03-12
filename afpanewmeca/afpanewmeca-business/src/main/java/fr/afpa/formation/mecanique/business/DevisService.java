package fr.afpa.formation.mecanique.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.mecanique.persistence.entity.or.Devis;
import fr.afpa.formation.mecanique.persistence.repository.DevisRepository;

@Service
public class DevisService {
	@Autowired
	private DevisRepository dr;
	
	public void createDevis(Devis d) {
		dr.save(d);
	}
	
	public List<Devis> findAll() {
		return (List<Devis>) dr.findAll();
	}

}
