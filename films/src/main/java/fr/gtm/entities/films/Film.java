package fr.gtm.entities.films;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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
	
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)		//manytomany unidirectionnel
	@JoinTable(name = "film_acteur",					//il faut une table de jointure
			joinColumns=@JoinColumn(name="fk_film"),	//clé de jointure pour la classe film (colonne qui correspond à la classe film)
			inverseJoinColumns=@JoinColumn(name="fk_acteur"))	//clé de jointure pour la classe Acteur
	private List<Acteur> acteurs = new ArrayList<Acteur>();
	
//	@Transient
//	private Map<String, Acteur> roles = new	HashMap<String, Acteur>();//les roles font parti du film, et ils faut pouvoir relier les roles aux acteurs
//	//on fait donc un map entre un role et un acteur.

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

//	public Map<String, Acteur> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(Map<String, Acteur> roles) {
//		this.roles = roles;
//	}
	
	public List<Acteur> getActeurs() {
		return acteurs;
	}

	public void setActeurs(List<Acteur> acteurs) {
		this.acteurs = acteurs;
	}
	
}
