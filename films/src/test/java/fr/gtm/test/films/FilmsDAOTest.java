package fr.gtm.test.films;

import static org.junit.Assert.*;


import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.gtm.entities.films.Film;
import fr.gtm.entities.films.FilmDAO;




public class FilmsDAOTest {
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
	public void newDao() {
		FilmDAO dao = new FilmDAO(emf);
		assertNotNull(dao);
	}
	
	
	@Test
	public void testFindById() {
		FilmDAO dao = new FilmDAO(emf);
//		assertNotNull(dao);
		Film film = dao.findById(1L);
		assertNotNull(film);
			
	}
	
	
	@Test
	public void testFindAllFilms() {
		FilmDAO dao = new FilmDAO(emf);
		List<Film> films = dao.getAll();
		assertNotNull(films);
		assertFalse(films.isEmpty());
	}
	
	@Test
	public void testFilmActeurs() {
		FilmDAO dao = new FilmDAO(emf);
		Film film = dao.findById(1L);
		assertTrue(film.getActeurs().isEmpty());
	}
	
	

}
