package fr.afpa.formation.mecanique.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import fr.afpa.formation.mecanique.business.VehiculeService;
import fr.afpa.formation.mecanique.persistence.entity.utilisateur.Vehicule;

@Controller
public class VehiculeController {
	@Autowired
	VehiculeService vehiculeService;

	@GetMapping("/vehicules")
	public String listVehicules(Model model) throws Exception {
		model.addAttribute("vehicules", vehiculeService.findAll());
		return "listeVehicules";
	}

	@GetMapping("/add/vehicule")
	public String creerVehicule(Model model) {
		model.addAttribute("vehicule", new Vehicule());
		return "creerVehicule";
	}

	@PostMapping("/add/vehicule")
	public String addNewVehicule(Vehicule v) {
		try {
			// TODO get dateMiseEnCirculation
			v.setDateMiseEnCirculation(new Date());
			vehiculeService.create(v);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/vehicules";

	}

}
