package fr.afpa.formation.mecanique.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.mecanique.persistence.entity.cq.Niveau;
import fr.afpa.formation.mecanique.persistence.repository.NiveauRepository;

@Service
public class NiveauxService {
	@Autowired
	NiveauRepository nr;
	
	public void createNiveau(Niveau n) {nr.save(n);}
	
	public List<Niveau> findAll(){return (List<Niveau>)nr.findAll();}
	
	public Niveau findById(Long id) throws Exception {
		if (id == null) {
			throw new Exception("Niveau findById: l'id est null");
		}

		Niveau f = nr.findById(id).get();

		if (f == null) {
			throw new Exception("Niveau findById: le Niveau est null");
		}

		return f;
	}

}
