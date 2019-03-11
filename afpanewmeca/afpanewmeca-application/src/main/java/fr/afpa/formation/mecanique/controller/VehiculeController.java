package fr.afpa.formation.mecanique.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.afpa.formation.mecanique.persistence.entity.utilisateur.Vehicule;


@Controller
public class VehiculeController {
	
	@GetMapping("/vehicules")
	public  String listVehicules(Model model) throws Exception {
		List<Vehicule> listVehicules = new ArrayList<>();
		listVehicules.add(new Vehicule("Peugeot", "207CC", 10.000, "GDF54564564PM", "HG54545OP", "AX-777-NG", "25454545454", new Date()));
		listVehicules.add(new Vehicule("Mercedes", "A", 50.000, "GHG33544654MP", "AXA54654", "XS-533-NB", "564964513131r", new Date()));
		listVehicules.add(new Vehicule("BMW", "X5", 80.000, "XD65469JH", "LF8432", "CD-123-DK", "5465484646854ppl", new Date()));
		
		model.addAttribute("vehicules", listVehicules);
		return "listeVehicules";
	}

}
