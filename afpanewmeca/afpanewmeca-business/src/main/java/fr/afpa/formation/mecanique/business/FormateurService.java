package fr.afpa.formation.mecanique.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.mecanique.persistence.entity.utilisateur.Formateur;
import fr.afpa.formation.mecanique.persistence.repository.FormateurRepository;

@Service
public class FormateurService {
	@Autowired
	FormateurRepository formateurRepository;
	
	public void createFormateur(Formateur f) {
		formateurRepository.save(f);
	}
	
	public List<Formateur> findAll(){
		return (List<Formateur>) formateurRepository.findAll();
	}
	
	public Formateur update(Formateur formateur) throws Exception {
		if ((formateur == null) || (formateur.getId() == null)) {
			throw new Exception("Le Formateur est null ou son id est null");
		}

		Long idAChercher = formateur.getId();
		Optional<Formateur> formateurOptional = formateurRepository.findById(idAChercher);

		if (!formateurOptional.isPresent()) {
			throw new Exception("Le Formateur n'a pas été trouvé");
		}
		return formateurRepository.save(formateur);
	}
	
	
	public void deleteById(Long id) throws Exception {
		if (id == null) {
			throw new Exception("Id est null");
		}

		Optional<Formateur> formateurOptional = formateurRepository.findById(id);
		if (!formateurOptional.isPresent()) {
			throw new Exception("Formateur n'existe pas");
		}

		formateurRepository.deleteById(id);
	}

}
