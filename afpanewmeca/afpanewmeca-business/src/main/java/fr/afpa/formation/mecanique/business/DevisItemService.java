package fr.afpa.formation.mecanique.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.mecanique.persistence.entity.or.DevisItem;
import fr.afpa.formation.mecanique.persistence.repository.DevisItemRepository;

@Service
public class DevisItemService {
	@Autowired
	DevisItemRepository dir;
	
	public void createDevisItem(DevisItem di) {
		dir.save(di);
	}
	
	public List<DevisItem> findAll(){
		return (List<DevisItem>) dir.findAll();
	}

}
