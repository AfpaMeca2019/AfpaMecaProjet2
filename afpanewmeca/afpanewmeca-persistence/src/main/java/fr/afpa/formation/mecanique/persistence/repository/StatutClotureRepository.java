package fr.afpa.formation.mecanique.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import fr.afpa.formation.mecanique.persistence.entity.statutCloture.StatutCloture;

public interface StatutClotureRepository extends CrudRepository<StatutCloture, Long> {

}
