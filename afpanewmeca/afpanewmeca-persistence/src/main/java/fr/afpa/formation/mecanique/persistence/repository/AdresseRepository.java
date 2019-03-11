package fr.afpa.formation.mecanique.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import fr.afpa.formation.mecanique.persistence.entity.utilisateur.Adresse;


public interface AdresseRepository extends CrudRepository<Adresse, Long> {

}
