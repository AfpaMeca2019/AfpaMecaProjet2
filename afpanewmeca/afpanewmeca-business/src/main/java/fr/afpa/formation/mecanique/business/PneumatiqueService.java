package fr.afpa.formation.mecanique.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.mecanique.persistence.entity.cq.Pneumatique;
import fr.afpa.formation.mecanique.persistence.repository.PneumatiqueRepository;

@Service
public class PneumatiqueService {
	@Autowired
	PneumatiqueRepository pr;
	
	public void createPneumatique(Pneumatique p) {
		pr.save(p);
	}
	
	public List<Pneumatique> findAll(){
		return (List<Pneumatique>) pr.findAll();
	}
	
	public Pneumatique findById(Long id) throws Exception {
		if (id == null) {
			throw new Exception("Pneumatique findById: l'id est null");
		}

		Pneumatique f = pr.findById(id).get();

		if (f == null) {
			throw new Exception("Pneumatique findById: le Pneumatique est null");
		}

		return f;
	}

}
