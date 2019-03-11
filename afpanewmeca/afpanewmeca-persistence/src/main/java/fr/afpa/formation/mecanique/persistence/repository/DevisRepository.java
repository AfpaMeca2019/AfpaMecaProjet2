package fr.afpa.formation.mecanique.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import fr.afpa.formation.mecanique.persistence.entity.or.Devis;


public interface DevisRepository extends CrudRepository<Devis, Long> {

}
