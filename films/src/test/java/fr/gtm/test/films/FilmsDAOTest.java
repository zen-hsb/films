package fr.gtm.test.films;

import static org.junit.Assert.*;

import java.time.LocalDate;
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
		FilmDAO dao = new FilmDAO(emf);			//ici, on va tester la classe FILM et pas la class ACTEUR : on teste une classe à la fois !
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
	
//	@Test
//	public void testFilmActeurs() {
//		FilmDAO dao = new FilmDAO(emf);
//		Film film = dao.findById(1L);
//		assertFalse(film.getActeurs().isEmpty());
//	}
	
	
	@Test
	public void create() {		//je vérifie que je crée bien un film avec un id différent
		FilmDAO dao = new FilmDAO(emf);
		Film film = new Film();
		film.setTitre("Back to the future");
		film.setDuree(110);
		film.setDateSortie(LocalDate.of(1980, 01, 27));
		
		dao.create(film);
//		assertNotEquals(0, film.getId());
		assertEquals(17, film.getId());
		
	}
	
	
	
	
	
	
	
	
	public void testFilmsRoles() {
		
	}
		//Map<role, Acteur> roles = new HashMap<>();
		//role.put(new Role("Clar kent"), new Acteur("M", "Michael J", "Fox")
		//role.put(new Role("Clar kent"), new Acteur("M", "Michael J", "Fox")
	
		//film.setRole();
	
	
	
	
	//Map<String, Acteur> roles = new HashMap<String, Acteur>();
}
