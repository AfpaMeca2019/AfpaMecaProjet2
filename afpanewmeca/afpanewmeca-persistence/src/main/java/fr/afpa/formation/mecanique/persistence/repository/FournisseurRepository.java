package fr.afpa.formation.mecanique.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import fr.afpa.formation.mecanique.persistence.entity.or.Fournisseur;


public interface FournisseurRepository extends CrudRepository<Fournisseur, Long> {

}
