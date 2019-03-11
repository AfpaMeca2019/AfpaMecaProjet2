package fr.afpa.formation.mecanique.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import fr.afpa.formation.mecanique.persistence.entity.cq.Eclairage;


public interface EclairageRepository extends CrudRepository<Eclairage, Long> {

}
