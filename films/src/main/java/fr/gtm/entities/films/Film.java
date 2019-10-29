package fr.gtm.entities.films;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.relation.Role;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;


import javax.persistence.JoinColumn;

@Entity
@Table(name = "films")
@Access(AccessType.FIELD)
@NamedQuery(name="Film.all",query = "SELECT f FROM Film f")
public class Film {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_film")
	private long id;
	private String titre;
	private String realisateur;
	@Column(name = "date_sortie")
	private LocalDate dateSortie;
	private int duree;	//durée en minutes
	
//	@Transient
	
//	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)		//manytomany unidirectionnel
//	@JoinTable(name = "film_acteur",					//il faut une table de jointure
//			joinColumns=@JoinColumn(name="fk_film"),	//clé de jointure pour la classe film (colonne qui correspond à la classe film)
//			inverseJoinColumns=@JoinColumn(name="fk_acteur"))	//clé de jointure pour la classe Acteur
//	private List<Acteur> acteurs = new ArrayList<Acteur>();		//LISTE/COLLECTION D'ACTEURS
	
//	@Transient
	
	
	
	
	
	
//	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)		//manytomany bidirectionnel avec MAP mais sans Role.
//	@JoinTable(name = "film_acteur",					//il faut une table de jointure
//			joinColumns=@JoinColumn(name="fk_film"),	//clé de jointure pour la classe film (colonne qui correspond à la classe film)
//			inverseJoinColumns=@JoinColumn(name="fk_acteur"))
//	@MapKeyColumn	
//	private Map<String, Acteur> roles = new	HashMap<String, Acteur>();
	
	
	
	
	
	
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)		//manytomany unidirectionnel
	@JoinTable(name = "film_acteur",					//il faut une table de jointure
			joinColumns=@JoinColumn(name="fk_film"),	//clé de jointure pour la classe film (colonne qui correspond à la classe film)
			inverseJoinColumns=@JoinColumn(name="fk_acteur"))
	private Map<Role, Acteur> roles = new	HashMap<Role, Acteur>();	//les roles font parti du film, et il faut pouvoir relier les roles aux acteurs
	//on fait donc un map entre un role et un acteur. 
																					//ICI : ON EST EN EMBEDDABLE MANY TO MANY MAP : ON AJOUTE DONC LA CLASSE "ROLE" : on peut ainsi rajouter des propriétés et des méthode (au lieu d'avoir juste "String")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getRealisateur() {
		return realisateur;
	}

	public void setRealisateur(String realisateur) {
		this.realisateur = realisateur;
	}

	public LocalDate getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(LocalDate dateSortie) {
		this.dateSortie = dateSortie;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}
	
	
	

	public Map<Role, Acteur> getRoles() {
		return roles;
	}

	public void setRoles(Map<Role, Acteur> roles) {
		this.roles = roles;
	}
	
	public void add(Role role,Acteur acteur) {
		roles.put(role, acteur);
	}
	
	
//	
//	public List<Acteur> getActeurs() {
//		return acteurs;
//	}
//
//	public void setActeurs(List<Acteur> acteurs) {
//		this.acteurs = acteurs;
//	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateSortie == null) ? 0 : dateSortie.hashCode());
		result = prime * result + duree;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((realisateur == null) ? 0 : realisateur.hashCode());
//		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
		result = prime * result + ((titre == null) ? 0 : titre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (dateSortie == null) {
			if (other.dateSortie != null)
				return false;
		} else if (!dateSortie.equals(other.dateSortie))
			return false;
		if (duree != other.duree)
			return false;
		if (id != other.id)
			return false;
		if (realisateur == null) {
			if (other.realisateur != null)
				return false;
		} else if (!realisateur.equals(other.realisateur))
			return false;
//		if (roles == null) {
//			if (other.roles != null)
//				return false;
//		} else if (!roles.equals(other.roles))
//			return false;
		if (titre == null) {
			if (other.titre != null)
				return false;
		} else if (!titre.equals(other.titre))
			return false;
		return true;
	}



	
}
