package fr.afpa.formation.mecanique.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import fr.afpa.formation.mecanique.persistence.entity.typePaiement.TypePaiement;

public interface TypePaiementRepository extends CrudRepository<TypePaiement, Long> {

}
