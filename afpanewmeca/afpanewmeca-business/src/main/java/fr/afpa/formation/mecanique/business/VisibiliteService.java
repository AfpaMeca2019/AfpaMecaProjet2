package fr.afpa.formation.mecanique.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.mecanique.persistence.entity.cq.Visibilite;
import fr.afpa.formation.mecanique.persistence.repository.VisibiliteRepository;

@Service
public class VisibiliteService {
	@Autowired
	VisibiliteRepository vr;
	
	public void createVisibilite(Visibilite v) {
		vr.save(v);
	}
	
	public List<Visibilite> findAll(){
		return (List<Visibilite>) vr.findAll();
	}
	
	public Visibilite findById(Long id) throws Exception {
		if (id == null) {
			throw new Exception("Visibilite findById: l'id est null");
		}

		Visibilite f = vr.findById(id).get();

		if (f == null) {
			throw new Exception("Visibilite findById: le Visibilite est null");
		}

		return f;
	}

}
