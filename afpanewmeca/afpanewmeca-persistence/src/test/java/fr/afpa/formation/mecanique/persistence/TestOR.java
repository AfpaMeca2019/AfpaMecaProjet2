package fr.afpa.formation.mecanique.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import fr.afpa.formation.mecanique.persistence.entity.or.Cloture_OR;
import fr.afpa.formation.mecanique.persistence.entity.or.OrdreReparation;
import fr.afpa.formation.mecanique.persistence.entity.statutCloture.RefusClient;
import fr.afpa.formation.mecanique.persistence.entity.statutCloture.RefusFormateur;
import fr.afpa.formation.mecanique.persistence.entity.statutCloture.ReparationEffectuee;
import fr.afpa.formation.mecanique.persistence.entity.statutCloture.StatutCloture;
import fr.afpa.formation.mecanique.persistence.entity.statutOR.AttenteValidationFormateur;
import fr.afpa.formation.mecanique.persistence.entity.statutOR.Cloture;
import fr.afpa.formation.mecanique.persistence.entity.statutOR.DemandeCloture;
import fr.afpa.formation.mecanique.persistence.entity.statutOR.EnReparation;
import fr.afpa.formation.mecanique.persistence.entity.statutOR.StatutValidationClient;
import fr.afpa.formation.mecanique.persistence.entity.statutOR.Statut_OR;
import fr.afpa.formation.mecanique.persistence.repository.ClotureORRepository;
import fr.afpa.formation.mecanique.persistence.repository.OrdreReparationRepository;
import fr.afpa.formation.mecanique.persistence.repository.StatutClotureRepository;
import fr.afpa.formation.mecanique.persistence.repository.StatutORRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = SmallApp.class)
public class TestOR {

	@Autowired
	OrdreReparationRepository orr;
	@Autowired
	ClotureORRepository corr;
	@Autowired
	StatutClotureRepository sorr;
	@Autowired
	StatutORRepository scr;

	@Autowired
	TestEntityManager entity;
	int initSize = 3;
	Long lastNumeroOr;

	@Before
	public void setUp() {
		StatutCloture sc1 = new ReparationEffectuee();
		StatutCloture sc2 = new RefusFormateur();
		StatutCloture sc3 = new RefusClient();
		sorr.save(sc1);
		sorr.save(sc2);
		sorr.save(sc3);
		Cloture_OR c1 = new Cloture_OR();
		c1.setStatutCloture(sc1);

		Cloture_OR c2 = new Cloture_OR();
		c2.setStatutCloture(sc2);

		Cloture_OR c3 = new Cloture_OR();
		c3.setStatutCloture(sc3);

		corr.save(c1);
		corr.save(c2);
		corr.save(c3);

		Statut_OR so1 = new Cloture();
		Statut_OR so2 = new AttenteValidationFormateur();
		Statut_OR so3 = new StatutValidationClient();
		Statut_OR so4 = new EnReparation();
		Statut_OR so5 = new DemandeCloture();
		scr.save(so1);
		scr.save(so2);
		scr.save(so3);
		scr.save(so4);
		scr.save(so5);
		OrdreReparation o1 = new OrdreReparation();
		o1.setNumeroOR("00001");
		o1.setClotureor(c1);
		o1.setDateCreation(new Date());
		o1.setDateSortie(new Date());
		o1.setFutursTravaux("bla");
		o1.setInterventionsARealiser("bli");
		o1.setStatutor(so1);
		o1.setSymptomesClient("blo");

		entity.persist(o1);

		OrdreReparation o2 = new OrdreReparation();
		o2.setNumeroOR("00002");
		o2.setClotureor(c2);
		o2.setDateCreation(new Date());
		o2.setDateSortie(new Date());
		o2.setFutursTravaux("blaaa");
		o2.setInterventionsARealiser("bliii");
		o2.setStatutor(so2);
		o2.setSymptomesClient("blooo");

		entity.persist(o2);

		OrdreReparation o3 = new OrdreReparation();
		o3.setNumeroOR("00003");
		o3.setClotureor(c3);
		o3.setDateCreation(new Date());
		o3.setDateSortie(new Date());
		o3.setFutursTravaux("blaa");
		o3.setInterventionsARealiser("blii");
		o3.setStatutor(so3);
		o3.setSymptomesClient("bloo");
		
		lastNumeroOr = (Long) entity.persistAndGetId(o3);

		entity.persist(o3);
	}

	@Test
	public void findAllTest() {
		assertEquals(3, orr.count());
	}

	@Test
	public void create() {

		OrdreReparation o4 = new OrdreReparation();
		o4.setNumeroOR("00004");
		o4.setClotureor(corr.findById(1l).get());
		o4.setDateCreation(new Date());
		o4.setDateSortie(new Date());
		o4.setFutursTravaux("blasdfgsdfgsdfga");
		o4.setInterventionsARealiser("blsdfgsdfgsdfgii");
		o4.setStatutor(scr.findById(1l).get());
		o4.setSymptomesClient("blsdfgsdfgsdfgoo");
		orr.save(o4);

		assertEquals(orr.count(), 4);

	}

	@Test
	public void update() {
		try {
			OrdreReparation f = orr.findById(lastNumeroOr).get();
			assertNotNull(f);
			assertNotEquals(f.getNumeroOR(), "000003");

			f.setNumeroOR("000003");
			orr.save(f);
			assertEquals(f.getNumeroOR(), "000003");
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	@Test
	public void delete() {
		OrdreReparation f = orr.findById(lastNumeroOr).get();

		orr.delete(f);
		assertEquals(orr.count(), 2);
		assertFalse(orr.findById(lastNumeroOr).isPresent());
	}

}
