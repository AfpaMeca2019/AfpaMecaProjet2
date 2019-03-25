package fr.afpa.formation.mecanique.controller;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import fr.afpa.formation.mecanique.business.PieceService;
import fr.afpa.formation.mecanique.persistence.entity.or.Devis;
import fr.afpa.formation.mecanique.persistence.entity.or.DevisItem;

@Controller
public class PieceController {
	
	@Autowired
	PieceService pieceService;

	

	@GetMapping("/createDevisItem")
	public String createDevisItem(Model model, HttpServletRequest request) throws Exception {
		//TODO IL FAUDRAIT RECUP LE "FOURNISSEUR" ET LE "MOYEN DE PAYMENT" SELECTIONNÉ DANS LE "createDevis" A L'ARRIVER DANS "createDevisItem"
		//POUR NE PAS LES PERDRE AU PASSAGE DE "createDevisItem" A "createDevis"
		
//			
//		
//		Map<String, Object> modelAsMap = model.asMap();
//		Devis devis = (Devis) modelAsMap.get("devis");
//		
//		
//		
//		if(devis != null) {
//			DevisController.saveDevisIntoSession(request.getSession(), devis);
//			
//		}else {			
//			throw new Exception("DEVIS NULL");
//			
//		}
//		System.out.println(devis);
		
		
		Devis devis  = DevisController.getDevisFromSession(request.getSession());
		DevisController.saveDevisIntoSession(request.getSession(), devis);
		
		
		model.addAttribute("newItem", new DevisItem());
		return "createPiece";
	}

	@PostMapping("/createDevisItem")
	public String doCreateDevisItem(DevisItem devisItem , Model m, HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession();
		Set<DevisItem> devisItems =  DevisController.getPiecesFromSession(session);
		
		if(devisItems == null) 	devisItems = new HashSet<>();
		if(devisItem != null) {
			devisItems.add(devisItem);
			
			DevisController.savePiecesIntoSession(session, devisItems);
		}else {
			
			throw new Exception("DEVIS-ITEM NULL");
		}
		return "redirect:/createDevis";
	}
	
	@GetMapping("/deleteDevisItem")
	public String doDeleteDevisItem(DevisItem devisItem , Model m, HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession();
		Set<DevisItem> devisItems =  DevisController.getPiecesFromSession(session);
		
		if(devisItems == null) 	devisItems = new HashSet<>();
		if(devisItem != null) {
			devisItems.remove(devisItem);
			
			DevisController.savePiecesIntoSession(session, devisItems);
		}else {
			
			throw new Exception("DEVIS-ITEM NULL");
		}
		return "redirect:/createDevis";
	}
}
