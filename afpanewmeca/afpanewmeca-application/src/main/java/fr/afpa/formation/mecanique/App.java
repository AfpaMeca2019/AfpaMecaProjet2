package fr.afpa.formation.mecanique;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.afpa.formation.mecanique.business.ClientService;
import fr.afpa.formation.mecanique.business.DevisItemService;
import fr.afpa.formation.mecanique.business.DevisService;
import fr.afpa.formation.mecanique.business.FournisseurService;
import fr.afpa.formation.mecanique.business.PieceService;
import fr.afpa.formation.mecanique.business.TypePaiementService;
import fr.afpa.formation.mecanique.business.VehiculeService;
import fr.afpa.formation.mecanique.persistence.entity.or.Devis;
import fr.afpa.formation.mecanique.persistence.entity.or.DevisItem;
import fr.afpa.formation.mecanique.persistence.entity.or.Fournisseur;
import fr.afpa.formation.mecanique.persistence.entity.or.Piece;
import fr.afpa.formation.mecanique.persistence.entity.typePaiement.TypePaiement;
import fr.afpa.formation.mecanique.persistence.entity.utilisateur.Client;
import fr.afpa.formation.mecanique.persistence.entity.utilisateur.Vehicule;

@SpringBootApplication
public class App implements CommandLineRunner {

	@Autowired
	VehiculeService vehiculeRepository;
	@Autowired
	ClientService clientRepository;
	@Autowired
	DevisService ds;
	@Autowired
	PieceService ps;
	@Autowired
	DevisItemService dis;
	@Autowired
	FournisseurService fs;
	@Autowired
	TypePaiementService tps;
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	public void run(String... args) throws Exception {
		init();
	}
	
	public void init() throws Exception {

		Client c1 = new Client("Gontrand", "Jean-eude", "0605040708", "123@g.com",  "ABC123", new Date(), true);
		Client c2 = new Client("Play", "Henry", "0605040709", "123aze@ff.com", "XYZ987", new Date(), true);
		
		
		Vehicule veh1 = new Vehicule("Peugeot", "207CC", 10.000, "GDF54564564PM", "HG54545OP", "AX-777-NG", "25454545454", new Date());
		Vehicule veh2 = new Vehicule("Mercedes", "A", 50.000, "GHG33544654MP", "AXA54654", "XS-533-NB", "564964513131r", new Date());
		Vehicule veh3 = new Vehicule("BMW", "X5", 80.000, "XD65469JH", "LF8432", "CD-123-DK", "5465484646854ppl", new Date());

		vehiculeRepository.create(veh1);
		vehiculeRepository.create(veh2);
		vehiculeRepository.create(veh3);

		Set<Vehicule> listVehC1 = new HashSet<>();
		listVehC1.add(veh1);
		Set<Vehicule> listVehC2 = new HashSet<>();	
		listVehC2.add(veh2);
		listVehC2.add(veh3);

		c1.setListVehicule(listVehC1);
		c2.setListVehicule(listVehC2);

		clientRepository.create(c1);
		clientRepository.create(c2);
		
		Piece p1 = new Piece("0001", "test", 12.0);
		ps.create(p1);
		
		DevisItem di1 = new DevisItem(p1, 3);
		dis.createDevisItem(di1);
		TypePaiement tp1 = new TypePaiement("Chèques");
		tps.createTypePaiement(tp1);
		Fournisseur f = new Fournisseur("001", "test");
		fs.createFournisseur(f);
		
		Devis d1 = new Devis(new Date(), "001", new Date(), tp1, f);
		ds.createDevis(d1);
	}
}
