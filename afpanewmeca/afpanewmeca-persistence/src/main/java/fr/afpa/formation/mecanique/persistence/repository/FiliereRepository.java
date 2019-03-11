package fr.afpa.formation.mecanique.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import fr.afpa.formation.mecanique.persistence.entity.utilisateur.Filiere;


public interface FiliereRepository extends CrudRepository<Filiere, Long> {

}
