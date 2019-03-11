package fr.afpa.formation.mecanique;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.afpa.formation.mecanique.persistence.entity.utilisateur.Client;
import fr.afpa.formation.mecanique.persistence.entity.utilisateur.Vehicule;
import fr.afpa.formation.mecanique.persistence.repository.ClientRepository;
import fr.afpa.formation.mecanique.persistence.repository.VehiculeRepository;

@SpringBootApplication
public class App implements CommandLineRunner {

	@Autowired
	VehiculeRepository vehiculeRepository;
	
	@Autowired
	ClientRepository clientRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	public void run(String... args) throws Exception {
		init();
	}
	
	public void init() {

		Client c1 = new Client("Gontrand", "Jean-eude", "0605040708", "123@g.com", "CL001", "ABC123", new Date(), true);
		Client c2 = new Client("Play", "Henry", "0605040709", "123aze@ff.com", "CL002", "XYZ987", new Date(), true);
		
		
		Vehicule veh1 = new Vehicule("Peugeot", "207CC", 10.000, "GDF54564564PM", "HG54545OP", "AX-777-NG", "25454545454", new Date());
		Vehicule veh2 = new Vehicule("Mercedes", "A", 50.000, "GHG33544654MP", "AXA54654", "XS-533-NB", "564964513131r", new Date());
		Vehicule veh3 = new Vehicule("BMW", "X5", 80.000, "XD65469JH", "LF8432", "CD-123-DK", "5465484646854ppl", new Date());

		vehiculeRepository.save(veh1);
		vehiculeRepository.save(veh2);
		vehiculeRepository.save(veh3);

		Set<Vehicule> listVehC1 = new HashSet<>();
		listVehC1.add(veh1);
		Set<Vehicule> listVehC2 = new HashSet<>();	
		listVehC2.add(veh2);
		listVehC2.add(veh3);

		c1.setListVehicule(listVehC1);
		c2.setListVehicule(listVehC2);

		clientRepository.save(c1);
		clientRepository.save(c2);
	}
}
