package fr.afpa.formation.mecanique.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.mecanique.persistence.entity.utilisateur.Client;
import fr.afpa.formation.mecanique.persistence.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	ClientRepository cr;
	
	public List<Client> findAll(){
		return (List<Client>) cr.findAll();
	}
	
	public Long create(Client client) {		
		Client savedClient = cr.save(client);
		return savedClient.getId();
	}

}
