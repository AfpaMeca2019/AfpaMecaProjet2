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
import fr.afpa.formation.mecanique.persistence.entity.utilisateur.Client;

@Controller
public class ClientController {

	@Autowired
	ClientService cs;

	//@Autowired
//	AddresseService addresseService;

	@GetMapping("/")
	public String start(Model model) throws Exception {
		model.addAttribute("clients", cs.findAll());
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
		//	AdresseService.create(client.getAdresse());
			cs.create(client);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}
}
