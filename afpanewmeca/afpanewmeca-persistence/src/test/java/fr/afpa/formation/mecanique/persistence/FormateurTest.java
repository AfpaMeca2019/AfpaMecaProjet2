package fr.afpa.formation.mecanique.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import fr.afpa.formation.mecanique.persistence.entity.utilisateur.Formateur;
import fr.afpa.formation.mecanique.persistence.repository.FormateurRepository;



@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = SmallApp.class)
public class FormateurTest {

	@Autowired
	FormateurRepository formateurRepository;

	@Autowired
	private TestEntityManager entityManager;

	private long idLastFormateur = 0l;
	int initSize = 3;
	String nom = "Vidal";
	String prenom = "JeanCharles";
	String telephone = "0705060809";
	String mail = "jcv@gmail.fr";
	String identifiant = "jcv";
	String motDePasse = "jcvmdp";
	String role = "formateur";
	

	@Before
	public void setUp() {
		Formateur formateur1 = new Formateur();

		formateur1.setNom(nom);
		formateur1.setPrenom(prenom);
		formateur1.setTelephone(telephone);
		formateur1.setIdentifiant(identifiant);
		formateur1.setMotDePasse(motDePasse);
		formateur1.setRole(role);
		formateur1.setMail(mail);
		formateur1.setInscription(new Date());
		formateur1.setRadiation(new Date());

		entityManager.persist(formateur1);

		Formateur formateur2 = new Formateur();

		formateur2.setNom("Dalgalian");
		formateur2.setPrenom("Tcharou");
		formateur2.setTelephone("0705040609");
		formateur2.setIdentifiant("tch");
		formateur2.setMotDePasse("tchMdp");
		formateur2.setRole("Git");
		formateur2.setMail("tcharou@tcha.fr");
		formateur2.setInscription(new Date());
		formateur2.setRadiation(new Date());

		entityManager.persist(formateur2);

		Formateur formateur3 = new Formateur();

		formateur3.setNom("Pagan");
		formateur3.setPrenom("JeanJacques");
		formateur3.setTelephone("0705040606");
		formateur3.setIdentifiant("jjp");
		formateur3.setMotDePasse("jjpMdp");
		formateur3.setRole("JS");
		formateur3.setMail("jj@pag.fr");
		formateur3.setInscription(new Date());
		formateur3.setRadiation(new Date());

		entityManager.persist(formateur3);

		idLastFormateur = (Long) entityManager.persistAndGetId(formateur3);

	}

	@Test
	public void findAll() {
		assertEquals(formateurRepository.count(), initSize);

	}

	@Test
	public void create() {

		Formateur f = new Formateur();
		f.setNom("nom1");
		f.setPrenom("prenom");
		f.setMail("f@f.fr");
		f.setTelephone("0654525356");
		f.setIdentifiant("nf");
		f.setMotDePasse("nmdp");
		f.setRole("newF");
		f.setInscription(new Date());
		f.setRadiation(new Date());
		formateurRepository.save(f);

		assertEquals(formateurRepository.count(), initSize + 1);

	}
	
	@Test
	public void update() {
		try {
			Formateur f = formateurRepository.findById(idLastFormateur).get();
			assertNotNull(f);
			assertNotEquals(f.getIdentifiant(), identifiant);
			
			f.setIdentifiant(identifiant);
			formateurRepository.save(f);
			assertEquals(f.getIdentifiant(), identifiant);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	@Test
	public void delete() {
		try {
			Formateur f = formateurRepository.findById(idLastFormateur).get();
			
			formateurRepository.delete(f);
			assertEquals(formateurRepository.count(), initSize - 1);
			assertFalse(formateurRepository.findById(idLastFormateur).isPresent());
		} catch (Exception e) {
			Assert.fail("the exception was not expected");
		}
	}
}
