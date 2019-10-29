package fr.gtm.entities.films;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class FilmDAO extends AbstractDAO<Film, Long> {

	public FilmDAO(EntityManagerFactory emf) {
		super(emf, Film.class);
	}
	
	public List<Film> getAll() {
		
		EntityManager em = emf.createEntityManager();
		List<Film> films = em.createNamedQuery("Film.all",Film.class)
		.getResultList();
//		List<Film> films = new ArrayList<Film>();
		em.close();
		return films;
	}
}
