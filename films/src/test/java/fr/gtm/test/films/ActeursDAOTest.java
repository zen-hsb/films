package fr.gtm.test.films;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.gtm.entities.films.Acteur;
import fr.gtm.entities.films.ActeurDAO;

public class ActeursDAOTest {
	private static EntityManagerFactory emf;
	
	@BeforeClass
	public static void before() {
		emf = Persistence.createEntityManagerFactory("films");
	}
	
	@AfterClass
	public static void after() {
		if(emf!=null) {
			emf.close();
		}
	}
	
	
	@Test
	public void testActeur() {
		EntityManager em = emf.createEntityManager();
		ActeurDAO dao = new ActeurDAO(emf);
		Acteur acteur = dao.findById(1L);
		assertFalse(acteur.getFilms().isEmpty());
		
		
	}

}
