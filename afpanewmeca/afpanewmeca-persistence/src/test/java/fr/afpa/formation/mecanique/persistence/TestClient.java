package fr.afpa.formation.mecanique.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.afpa.formation.mecanique.persistence.entity.utilisateur.Client;
import fr.afpa.formation.mecanique.persistence.repository.ClientRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes = SmallApp.class)
public class TestClient {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private ClientRepository clientRep;

	List<Client> clientList = new ArrayList<>();
	public Long idLastClient = 0l;
	int listSize;

	@Before
	public void setUp() {
		initBDD();
	}

	public void initBDD() {

		Client kiab = new Client();
		kiab.setNom("Thao");
		kiab.setPrenom("Kiab");
		kiab.setTelephone("0610203040");
		kiab.setMail("kiab@gmail.com");
		kiab.setNumero("N1");
		kiab.setNumeroCarteAfpa("123456789K");
		kiab.setDateInscription(new Date());
		kiab.setStatut(true);

		entityManager.persist(kiab);

		Client seb = new Client();
		seb.setNom("Granorolo");
		seb.setPrenom("Seb");
		seb.setTelephone("061208850");
		seb.setMail("seb@gmail.com");
		seb.setNumero("N2");
		seb.setNumeroCarteAfpa("222556789K");
		seb.setDateInscription(new Date());
		seb.setStatut(true);

		entityManager.persist(seb);

		Client nat = new Client();
		nat.setNom("MATHIEU");
		nat.setPrenom("Natalia");
		nat.setTelephone("0781978850");
		nat.setMail("nat@gmail.com");
		nat.setNumero("N3");
		nat.setNumeroCarteAfpa("1148556789K");
		nat.setDateInscription(new Date());
		nat.setStatut(true);

		idLastClient = (Long) entityManager.persistAndGetId(nat);

		clientList.add(kiab);
		clientList.add(seb);
		clientList.add(nat);

		listSize = clientList.size();

	}

	@Test
	public void List() {
		try {
			List<Client> list = (List<Client>) clientRep.findAll();
			assertNotNull(list);
			assertEquals(listSize, list.size());
		} catch (Exception e) {
			Assert.fail("The exception was not expected");
		}
	}

	@Test
	public void add() {
		Client olivier = new Client();
		olivier.setNom("Neveu");
		olivier.setPrenom("Olivier");
		olivier.setTelephone("066895850");
		olivier.setMail("olivier@gmail.com");
		olivier.setNumero("N4");
		olivier.setNumeroCarteAfpa("26764789K");
		olivier.setDateInscription(new Date());
		olivier.setStatut(true);

		clientRep.save(olivier);

		assertNotNull(olivier);
		assertEquals(clientRep.count(), 4);

	}

	@SuppressWarnings("unused")
	@Test
	public void findById() {

		String prenom = "Natalia";
		try {
			assertNotNull(idLastClient);
			Client client = clientRep.findById(idLastClient).get();
			assertEquals(client.getPrenom(), prenom);
		} catch (Exception e) {
			Assert.fail("This exception was not expected");
		}

		try {
			Client client2 = clientRep.findById(11L).get();
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	@Test
	public void update() {
		String newNumero = "N7";
		try {
			assertNotNull(idLastClient);
			Client client = clientRep.findById(idLastClient).get();
			client.setNumero(newNumero);
			clientRep.save(client);
			assertEquals(client.getNumero(), newNumero);

		} catch (Exception e) {
			Assert.fail("This exception was not expected");
		}

	}
	
	@Test
	public void delete() {
		try {
			assertNotNull(idLastClient);
			Client client = clientRep.findById(idLastClient).get();
			clientRep.delete(client);
			
			assertEquals(clientRep.count(), listSize-1);
		} catch (Exception e) {
			Assert.fail("This exception was not expected");
		}
	}
	

}
