package fr.afpa.formation.mecanique.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fr.afpa.formation.mecanique.business.FiliereService;
import fr.afpa.formation.mecanique.business.FormateurService;
import fr.afpa.formation.mecanique.business.ReferentService;
import fr.afpa.formation.mecanique.business.StagiaireService;
import fr.afpa.formation.mecanique.business.UtilisateurService;
import fr.afpa.formation.mecanique.persistence.entity.utilisateur.Formateur;
import fr.afpa.formation.mecanique.persistence.entity.utilisateur.Stagiaire;
import fr.afpa.formation.mecanique.persistence.entity.utilisateur.Utilisateur;

@Controller
public class UtilisateurController {
	@Autowired
	StagiaireService ss;
	@Autowired
	ReferentService rs;
	@Autowired
	FormateurService fs;
	@Autowired
	UtilisateurService us;
	@Autowired
	FiliereService fils;
	
	@GetMapping("/utilisateur")
	public String listUtilisateur(Model m) {
		List<Utilisateur> listAll = new ArrayList<>();
		listAll.addAll(ss.findAll());
		listAll.addAll(rs.findAll());
		listAll.addAll(fs.findAll());
		m.addAttribute("utilisateurs", listAll);
		m.addAttribute("listeFiliere",  fils.findAll());
		return "listeUtilisateurs";
	}
	
	@GetMapping("/create")
	public String beforeCreate() {
		return "choiceUser";
	}
	
	@PostMapping("/utilisateur/create/stagiaire")
	public String createStagiaire(Model m) {
		m.addAttribute("stagiaire", new Stagiaire());
		m.addAttribute("listeFiliere",  fils.findAll());
		return "createStagiaire";
	}
	
	@PostMapping("/utilisateur/create/formateur")
	public String createFormateur(Model m) {
		m.addAttribute("formateur", new Formateur());
		return "createFormateur";
	}
	
	@PostMapping("doCreate/stagiaire")
	public String doCreateStagiaire(@Valid Stagiaire s) {
		s.setInscription(new Date());
		s.setRole("Stagiaire");
		ss.createStagiare(s);
		return "redirect:/utilisateur";
	}
	
	@PostMapping("doCreate/formateur")
	public String doCreateFormateur(@Valid Formateur s) {
		s.setInscription(new Date());
		s.setRole("Stagiaire");
		fs.createFormateur(s);
		return "redirect:/utilisateur";
	}
	
	@GetMapping("/searchCarte/{carte}")
	public String searchCarte(Model m, @PathVariable(name="carte")String carte) {
		m.addAttribute("stagiaireSearch", ss.findByCarte(carte));
		return "search";
	}
	
	@GetMapping("/searchIdentifiant/{id}")
	public String searchIdentifiant(Model m, @PathVariable(name="id")String identifiant) {
		m.addAttribute("stagiaireSearch",  us.findByIdentifiant(identifiant));
		return "search";
	}
	
	@GetMapping("/searchFiliere/{fil}")
	public String searchFiliere(Model m, @PathVariable(name="fil") String f) {
		m.addAttribute("stagiaireSearch", ss.findByFiliere(f));
		return "search";
	}
}