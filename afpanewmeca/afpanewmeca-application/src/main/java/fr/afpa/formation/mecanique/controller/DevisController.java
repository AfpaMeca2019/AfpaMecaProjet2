package fr.afpa.formation.mecanique.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import fr.afpa.formation.mecanique.business.DevisItemService;
import fr.afpa.formation.mecanique.business.DevisService;
import fr.afpa.formation.mecanique.business.FournisseurService;
import fr.afpa.formation.mecanique.business.PieceService;
import fr.afpa.formation.mecanique.business.TypePaiementService;
import fr.afpa.formation.mecanique.persistence.entity.or.Devis;
import fr.afpa.formation.mecanique.persistence.entity.or.DevisItem;
import fr.afpa.formation.mecanique.persistence.entity.or.Fournisseur;
import fr.afpa.formation.mecanique.persistence.entity.or.Piece;
import fr.afpa.formation.mecanique.persistence.entity.typePaiement.TypePaiement;

@Controller
public class DevisController {

	
	@Autowired
	private DevisService devisService;

	@Autowired
	private FournisseurService fournisseurService;

	@Autowired
	private TypePaiementService typePaiementService;
	
	@Autowired
	private PieceService pieceService;
	
	@Autowired
	private DevisItemService devisItemService;
	
	@GetMapping("/devis")
	public String start(Model m) {
		m.addAttribute("devis", devisService.findAll());
		return "listeDevis";
	}
	
	@GetMapping("/createDevis")
	public String create(Model m, HttpServletRequest request) throws Exception {
		
		Devis newDevis = new Devis();
		List<Fournisseur> listFournisseur = fournisseurService.findAll();
		List<TypePaiement> listTypePaiement = typePaiementService.findAll();
		
		Set<DevisItem> fakeDevisItems = new HashSet<>();
		DevisItem fakeDevisItem1 = new DevisItem(new Piece("Ref123", "piece1", 22), 2);
		DevisItem fakeDevisItem2 = new DevisItem(new Piece("Ref124", "piece2", 22), 2);
		fakeDevisItems.add(fakeDevisItem1);
		fakeDevisItems.add(fakeDevisItem2);
		newDevis.setListDevisItem(fakeDevisItems);
		
		
		m.addAttribute("listFournisseur", listFournisseur);
		m.addAttribute("listTypePaiement", listTypePaiement);
		m.addAttribute("pieces", fakeDevisItems);
//		m.addAttribute("devisItems", newDevis.getListDevisItem());
		m.addAttribute("newDevis", newDevis);
		
		
		HttpSession session = request.getSession();
		session.setAttribute("devis", newDevis);		
		session.setAttribute("pieces", fakeDevisItems);
		return "creerDevis";
	}
	
////TODO ???
//	@GetMapping("/reloadDevis")
//	public String reloadAddDevisItem(Devis devis, Model m, HttpServletRequest request) throws Exception {
//
//		//remplire de Model m avec la session et le Devis 
//		//activer les input text dans le tableau des DevisItems et faire une nouvelle ligne en display:none
//		//reload la page de création
//		
//		
//		HttpSession session = request.getSession();
//		
//		
//		return "createDevis";
//	}

	@GetMapping("/createDevisItem")
	public String createDevisItem(Model m, HttpServletRequest request) throws Exception {

		
		m.addAttribute("newItem", new DevisItem());
		return "createPiece";
	}
	
		
	@PostMapping("/createDevis")
	public String doCreate(Devis devis, HttpServletRequest request,Model model) {
		Devis d2 = (Devis)request.getSession().getAttribute("devis");		
		request.getSession().removeAttribute("devis");
		
		
		devis.setListDevisItem(d2.getListDevisItem());
		
		List<DevisItem> findAllDevisItem = devisItemService.findAll();
		
		for (DevisItem devisItem : devis.getListDevisItem()) {
			if(findAllDevisItem.contains(devisItem)) {
					
				//devisItemService.update(devisItem);
			}else {
				
				devisItemService.create(devisItem);
			}
		}
		
		System.out.println("devis.toString() " + devis.toString());
//
//		System.out.println("listDevisItem.size() " +  d2.getListDevisItem().size());
		devis.setDateCreation(new Date());
		devis.setDatePaiement(new Date());
		devisService.createDevis(devis);
		return "redirect:/";
	}

}
