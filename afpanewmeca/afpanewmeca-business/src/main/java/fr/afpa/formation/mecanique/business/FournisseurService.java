package fr.afpa.formation.mecanique.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.mecanique.persistence.entity.or.Fournisseur;
import fr.afpa.formation.mecanique.persistence.repository.FournisseurRepository;

@Service
public class FournisseurService {
	
	@Autowired
	FournisseurRepository fournisseurRepository;

	public List<Fournisseur> findAll() throws Exception {
		List<Fournisseur> findAll = (List<Fournisseur>) fournisseurRepository.findAll();

		if ((findAll == null)) {
			throw new Exception("Fournisseur List exception: la liste est nulle");
		}

		return findAll;
	}

	public Fournisseur findById(Long id) throws Exception {
		if (id == null) {
			throw new Exception("Fournisseur findById: l'id est null");
		}

		Fournisseur f = fournisseurRepository.findById(id).get();

		if (f == null) {
			throw new Exception("Fournisseur findById: le fournisseur est null");
		}

		return f;
	}

	public Fournisseur create(Fournisseur f) throws Exception {
		if (f == null) {
			throw new Exception("Creation fournisseur exception: le fournisseur est null");
		}

		if (f.getId() != null) {
			Optional<Fournisseur> fOptional = fournisseurRepository.findById(f.getId());

			if (fOptional.isPresent()) {
				throw new Exception("Creation fournisseur exception: le Fournisseur existe dÃ©jÃ ");
			} else {
				throw new Exception("Creation fournisseur exception: l'id n'est pas null");
			}
		}

		return fournisseurRepository.save(f);

	}

	public Fournisseur update (Fournisseur f) throws Exception {
		if ((f == null) || (f.getId() == null)) {
			throw new Exception("Fournisseur update : le fournisseur est null ou son id est null");
		}

		Long idAChercher = f.getId();
		Optional<Fournisseur> FournisseurOptional = fournisseurRepository.findById(idAChercher);

		if (!FournisseurOptional.isPresent()) {
			throw new Exception("Fournisseur update : le Fournisseur n'a pas Ã©tÃ© trouvÃ©");
		}
		return fournisseurRepository.save(f);
	}
	
	public void deleteById(Long id) throws Exception {
		if (id == null) {
			throw new Exception("fournisseur delete by id: l'id est null");
		}

		Optional<Fournisseur> FournisseurOptional = fournisseurRepository.findById(id);
		if (!FournisseurOptional.isPresent()) {
			throw new Exception("Fournisseur with requested id does not exist");
		}

		fournisseurRepository.deleteById(id);
	}
	

}