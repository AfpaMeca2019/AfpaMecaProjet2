package fr.afpa.formation.mecanique.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fr.afpa.formation.mecanique.persistence.entity.utilisateur.Utilisateur;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long> {
	
	@Query("SELECT u From Utilisateur u WHERE u.identifiant LIKE :id")
	public List<Utilisateur> findByIdentifiant(@Param("id") String identifiant);

}
