package fr.afpa.formation.mecanique.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fr.afpa.formation.mecanique.persistence.entity.utilisateur.Stagiaire;

public interface StagiaireRepository extends CrudRepository<Stagiaire, Long> {

	@Query("SELECT s FROM Stagiaire s WHERE s.numeroCarteAfpa LIKE :carte")
	public List<Stagiaire> findByCarteAfpa(@Param("carte") String carte);
	
	@Query("SELECT s FROM Stagiaire s WHERE s.f.libelle LIKE :fil")
	public List<Stagiaire> findByFiliere(@Param("fil") String fil);
}
