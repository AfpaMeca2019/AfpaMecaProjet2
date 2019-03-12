package fr.afpa.formation.mecanique.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.afpa.formation.mecanique.business.PieceService;

@Controller
public class PieceController {
	
	@Autowired
	PieceService pieceService;

}
