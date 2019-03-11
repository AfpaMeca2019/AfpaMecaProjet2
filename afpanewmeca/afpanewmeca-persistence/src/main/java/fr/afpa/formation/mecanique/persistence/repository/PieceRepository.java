package fr.afpa.formation.mecanique.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import fr.afpa.formation.mecanique.persistence.entity.or.Piece;

public interface PieceRepository extends CrudRepository<Piece, Long> {

}
