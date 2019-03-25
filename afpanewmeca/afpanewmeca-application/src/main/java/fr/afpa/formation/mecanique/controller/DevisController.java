package fr.afpa.formation.mecanique.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.tags.form.HiddenInputTag;

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
	public String create(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();

		Map<String, Object> modelAsMap = model.asMap();

//		HiddenInputTag hiddenInputTag = (HiddenInputTag) modelAsMap.get("isClickNewPiece");
//        String valueHiddenField = ((ServletRequest) response).getParameter("isClickNewPiece");

		Devis newDevis = getDevisFromSession(session);
		Set<DevisItem> devisItemsFromSession = getPiecesFromSession(session);

		if (newDevis == null) {
			newDevis = new Devis();
			newDevis.setFournisseur(fournisseurService.findById(1l));
			newDevis.setTypePaiement(typePaiementService.findById(1l));
			saveDevisIntoSession(session, newDevis);

		}
		if (devisItemsFromSession != null) {
			newDevis.setListDevisItem(devisItemsFromSession);
		}
//		savePiecesIntoSession(session, devisItems);

		model.addAttribute("listFournisseur", fournisseurService.findAll());
		model.addAttribute("listTypePaiement", typePaiementService.findAll());
		
		if(newDevis.getTypePaiement() != null) {
			model.addAttribute("selectedTypePaiment", newDevis.getTypePaiement().getId());
		}
		
		if(newDevis.getFournisseur() != null ) {
			model.addAttribute("selectedFournisseur", newDevis.getFournisseur().getId());			
		}

		model.addAttribute("devis", newDevis);
		model.addAttribute("pieces", devisItemsFromSession);
		
		return "creerDevis";
	}

	@PostMapping("/createDevis")
	public String doCreate(Devis devis, HttpServletRequest request, Model model) throws Exception {

		String isPiece = request.getParameter("isPiece");
		HttpSession session = request.getSession();

		Devis d2 = getDevisFromSession(session);
		devis.setListDevisItem(d2.getListDevisItem());
		if (isPiece.equals("null")) {
			
			deleteDevisFromSession(session);
			deletePiecesFromSession(session);

			List<DevisItem> findAllDevisItem = devisItemService.findAll();

			for (DevisItem devisItem : devis.getListDevisItem()) {
				if (findAllDevisItem.contains(devisItem)) {

					// devisItemService.update(devisItem);
				} else {

					devisItemService.create(devisItem);
				}
			}

			devis.setDateCreation(new Date());
			devis.setDatePaiement(new Date());
			devisService.createDevis(devis);
			return "redirect:/devis";

		} else if(isPiece.equals("create")){
			saveDevisIntoSession(session, devis);
			return "redirect:/createDevisItem";
			
		}else if(isPiece.equals("delete")){
			saveDevisIntoSession(session, devis);
			return "redirect:/deleteDevisItem";
			
		}else {
			throw new Exception("Hidden Field 'isPiece' is not valid");
		}
	}

	public static Devis getDevisFromSession(HttpSession session) {

		return (Devis) session.getAttribute("devis");
	}

	public static void saveDevisIntoSession(HttpSession session, Devis devis) {

		session.setAttribute("devis", devis);
	}

	public static void deleteDevisFromSession(HttpSession session) {
		session.removeAttribute("devis");

	}

	public static Set<DevisItem> getPiecesFromSession(HttpSession session) {

		return (Set<DevisItem>) session.getAttribute("pieces");
	}

	public static void savePiecesIntoSession(HttpSession session, Set<DevisItem> pieces) {

		session.setAttribute("pieces", pieces);
	}

	public static void deletePiecesFromSession(HttpSession session) {
		session.removeAttribute("pieces");
		session.removeAttribute("selectedFournisseur");
		session.removeAttribute("selectedTypePaiment");
		session.removeAttribute("listTypePaiement");
		session.removeAttribute("listFournisseur");

	}

	// **************TEMPORARY*************************//
	private Set<DevisItem> getFakeDevisItems(HttpSession session) {
		Set<DevisItem> fakeDevisItems = new HashSet<>();
		DevisItem fakeDevisItem1 = new DevisItem(new Piece("Ref123", "piece1", 22), 2);
		DevisItem fakeDevisItem2 = new DevisItem(new Piece("Ref124", "piece2", 22), 2);
		fakeDevisItems.add(fakeDevisItem1);
		fakeDevisItems.add(fakeDevisItem2);

		DevisItem devisItem = (DevisItem) session.getAttribute("newDevisItem");
		if (devisItem != null) {
			fakeDevisItems.add(devisItem);
		}
		return fakeDevisItems;
	}
	// **************TEMPORARY*************************//

}
