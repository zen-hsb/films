package fr.gtm.entities.films;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ActeurDAO extends AbstractDAO<Acteur, Long>  {

	public ActeurDAO(EntityManagerFactory emf) {
		super(emf, Acteur.class);
	}
	
	public List<Acteur> getAll() {
		
		EntityManager em = emf.createEntityManager();
		List<Acteur> acteurs = em.createNamedQuery("Acteur.all",Acteur.class)
									.getResultList();
//		List<Acteur> acteurs = new ArrayList<Acteur>();
		em.close();
		return acteurs;
	}
		
}
