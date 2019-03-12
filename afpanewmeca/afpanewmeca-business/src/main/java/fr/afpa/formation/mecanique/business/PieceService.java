package fr.afpa.formation.mecanique.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.mecanique.persistence.entity.or.Piece;
import fr.afpa.formation.mecanique.persistence.repository.PieceRepository;

@Service
public class PieceService {

	@Autowired
	PieceRepository pieceRepository;

	public List<Piece> findAll() {
		return (List<Piece>) pieceRepository.findAll();
	}

	public Long create(Piece piece) throws Exception {

		if (piece == null) {
			throw new Exception("NotValidException");
		}

		if (piece.getId() != null) {

			Optional<Piece> pieceFromDB = pieceRepository.findById(piece.getId());
			if (pieceFromDB.isPresent()) {
				throw new Exception("AllreadyExistsException");
			} else {
				throw new Exception("NotValidException");

			}
		}
		Piece pieceSaved = pieceRepository.save(piece);
		return pieceSaved.getId();
	}

	
	
	
	public Long update(Piece piece) throws Exception {

		if (piece == null) {
			throw new Exception("NotValidException");
		}
		
		
		if (piece.getId() == null) {
			throw new Exception("NotValidException");
		} else {

			Optional<Piece> pieceFromDB = pieceRepository.findById(piece.getId());

			if (!pieceFromDB.isPresent()) {
				throw new Exception("NotFoundExcpetion");
			}
		}
		Piece pieceSaved = pieceRepository.save(piece);
		return pieceSaved.getId();
	}

	
	public void delete(Piece piece) throws Exception {	

		if (piece == null) {
			throw new Exception("NotValidException");
		} else if (piece.getId() == null) {
			throw new Exception("NotFoundExcpetion");
		}

		if (!findAll().contains(piece)) {
			throw new Exception("NotValidException");
		}
		
		pieceRepository.delete(piece);
	}

}
