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

import fr.afpa.formation.mecanique.business.AdresseService;
import fr.afpa.formation.mecanique.business.ClientService;
import fr.afpa.formation.mecanique.persistence.entity.utilisateur.Adresse;
import fr.afpa.formation.mecanique.persistence.entity.utilisateur.Client;

@Controller
public class ClientController {

	@Autowired
	ClientService clientService;

	@Autowired
	AdresseService adresseService;

	@GetMapping("/")
	public String index(Model model) throws Exception {
		return "index";
	}
	
	@GetMapping("/clients")
	public String start(Model model) throws Exception {
		model.addAttribute("clients", clientService.findAll());
		return "listClient";
	}

	@GetMapping("/add/client")
	public String create(Model model) {	
		model.addAttribute("client", new Client());
		return "createClient";
	}

	@PostMapping("/add/client")
	public String doCreate(Client client) {
		try {

			client.setDateInscription(new Date());
			
			Adresse adresse = client.getAdresse();
			adresse.setCodePostal("000000");
			
			adresseService.create(adresse);
			clientService.create(client);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}
}
