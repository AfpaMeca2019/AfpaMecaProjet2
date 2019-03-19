package fr.afpa.formation.mecanique.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.mecanique.persistence.entity.or.DevisItem;
import fr.afpa.formation.mecanique.persistence.repository.DevisItemRepository;
import fr.afpa.formation.mecanique.persistence.repository.PieceRepository;

@Service
public class DevisItemService {
	@Autowired
	DevisItemRepository devisItemRepository;
	
	@Autowired
	PieceRepository pieceRepository;
	
	public void create(DevisItem devisItem) {
		pieceRepository.save(devisItem.getPiece());
		devisItemRepository.save(devisItem);
	}	
	
	public List<DevisItem> findAll(){
		return (List<DevisItem>) devisItemRepository.findAll();
	}

}
