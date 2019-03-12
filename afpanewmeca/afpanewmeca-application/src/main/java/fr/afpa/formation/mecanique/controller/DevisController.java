package fr.afpa.formation.mecanique.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import fr.afpa.formation.mecanique.business.DevisService;
import fr.afpa.formation.mecanique.persistence.entity.or.Devis;

@Controller
public class DevisController {
	@Autowired
	private DevisService ds;
	
	@GetMapping("/devis")
	public String start(Model m) {
		m.addAttribute("devis", ds.findAll());
		return "listeDevis";
	}
	
	@GetMapping("/createDevis")
	public String create(Model m) {
		m.addAttribute("newDevis", new Devis());
		return "createDevis";
	}
	
	@PostMapping("/devis/create")
	public String doCreate(Devis d) {
		ds.createDevis(d);
		return "redirect:/";
	}

}
