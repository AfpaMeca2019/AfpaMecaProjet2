package fr.afpa.formation.mecanique.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import fr.afpa.formation.mecanique.persistence.entity.utilisateur.Client;



public interface ClientRepository extends CrudRepository<Client, Long> {

}
