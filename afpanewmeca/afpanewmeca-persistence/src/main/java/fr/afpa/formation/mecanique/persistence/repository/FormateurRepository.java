package fr.afpa.formation.mecanique.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import fr.afpa.formation.mecanique.persistence.entity.utilisateur.Formateur;


public interface FormateurRepository extends CrudRepository<Formateur, Long> {

}
