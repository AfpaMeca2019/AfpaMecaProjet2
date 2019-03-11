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

import fr.afpa.formation.mecanique.persistence.entity.or.Devis;
import fr.afpa.formation.mecanique.persistence.entity.or.DevisItem;
import fr.afpa.formation.mecanique.persistence.entity.or.Piece;
import fr.afpa.formation.mecanique.persistence.repository.DevisItemRepository;
import fr.afpa.formation.mecanique.persistence.repository.DevisRepository;
import fr.afpa.formation.mecanique.persistence.repository.PieceRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = SmallApp.class)
public class TestDevis {
	@Autowired
	PieceRepository pc;
	@Autowired
	DevisItemRepository dir;
	@Autowired
	DevisRepository dr;
	@Autowired
	TestEntityManager entity;
	
	private Long lastId;
	
	@Before
	public void setUp() {
		Piece p1 = new Piece("111", "test1", 12.0);
		Piece p2 = new Piece("222", "test2", 13.0);
		Piece p3 = new Piece("333", "test3", 14.0);
		pc.save(p1);
		pc.save(p2);
		pc.save(p3);
		
		DevisItem di1 = new DevisItem(p1, 2);
		DevisItem di2 = new DevisItem(p2, 3);
		DevisItem di3 = new DevisItem(p3, 1);
		dir.save(di1);
		dir.save(di2);
		dir.save(di3);
		
		Devis d1 = new Devis(new Date(), "001", new Date());
		Devis d2 = new Devis(new Date(), "002", new Date());
		d1.addDevisItem(di1);
		d1.addDevisItem(di2);
		d2.addDevisItem(di3);
		
		entity.persist(d1);
		lastId = (Long) entity.persistAndGetId(d2);
	}
	
	@Test
	public void findAllTest() {
		assertEquals(2, dr.count());
	}

	@Test
	public void create() {

		Devis d3 = new Devis();
		dr.save(d3);

		assertEquals(dr.count(), 3);

	}

	@Test
	public void update() {
		try {
			Devis f = dr.findById(lastId).get();
			assertNotNull(f);
			assertNotEquals(f.getNumDevis(), "000003");

			f.setNumDevis("000003");
			dr.save(f);
			assertEquals(f.getNumDevis(), "000003");
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	@Test
	public void delete() {
		Devis f = dr.findById(lastId).get();

		dr.delete(f);
		assertEquals(dr.count(), 1);
		assertFalse(dr.findById(lastId).isPresent());
	}


}
