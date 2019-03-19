package fr.afpa.formation.mecanique.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import fr.afpa.formation.mecanique.business.FournisseurService;
import fr.afpa.formation.mecanique.persistence.entity.or.Fournisseur;


@Controller
public class FournisseurController {
	
	@Autowired
	FournisseurService fService;
	
	@GetMapping("/fournisseurs")
	public  String listFournisseurs(Model model) throws Exception {	
		
		List<Fournisseur> listFournisseur = new ArrayList<>();
		try {
			listFournisseur = fService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			model.addAttribute("fournisseurs", listFournisseur);
		}
		
		return "listeFournisseurs";
}
	
	@GetMapping("/add/fournisseur")
	public String creerFournisseurs(Model model) {
		model.addAttribute("fournisseur", new Fournisseur());
		return "creerFournisseur";
	}
	
	@PostMapping("/add/fournisseur")
	public String addNewFournisseurs(Fournisseur f) {
		try {
			fService.create(f);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/fournisseurs";
		
	}

}
