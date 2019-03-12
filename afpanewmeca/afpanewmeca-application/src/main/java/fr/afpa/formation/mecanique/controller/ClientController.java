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

import fr.afpa.formation.mecanique.business.ClientService;
import fr.afpa.formation.mecanique.persistence.entity.utilisateur.Client;




@Controller
public class ClientController {
	
	@Autowired
	ClientService cs;

	@GetMapping("/")
	public String start(Model model) throws Exception {
		List<Client> listClient = new ArrayList<>();
		listClient.add(new Client("Gontrand", "Jean-eude", "0605040708", "123@g.com", "CL001", "ABC123", new Date(), true));
		
		model.addAttribute("clients", cs.findAll());
		return "listClient";
	}
	
	@GetMapping("/createClient")
	public String create(Model model) {
		model.addAttribute("client", new Client());
		return "createClient";
	}
	
	@PostMapping("/client/create")
	//todo
	public String doCreate(Client client) {
		cs.create(client);
		return "listClient";
	}
}
