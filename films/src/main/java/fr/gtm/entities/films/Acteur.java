package fr.gtm.entities.films;

import java.util.ArrayList;
import java.util.List;


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

@Entity
@Table(name="acteurs")
@Access(AccessType.FIELD)//pr que jpa controle que j'ai bien mis les champs sur les classes et pas sur les getteurs/setteurs
@NamedQuery(name="Acteur.all",query = "SELECT a FROM Acteur a")
public class Acteur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_acteur")
	private long id;
	private String civilite;
	private String nom;
	private String prenom;
	
	
	
	@ManyToMany(mappedBy = "acteurs",cascade = CascadeType.ALL) //manytomany bidirectionnel
	private List<Film> films = new ArrayList<Film>();
	
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getCivilite() {
		return civilite;
	}
	
	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public List<Film> getFilms() {
		return films;
	}
	
	public void setFilms(List<Film> films) {
		this.films = films;
	}
	
	
	
}
