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
import javax.persistence.JoinColumn;

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
	
	
	
//	@ManyToMany(mappedBy = "acteurs",cascade = CascadeType.ALL, fetch = FetchType.EAGER) //manytomany bidirectionnel : MAPPAGE PAR LA PROPRIETE ACTEUR QU'IL Y A DANS "FILM". SANS Role
//	private List<Film> films = new ArrayList<Film>();
	
	
	
	
	@ManyToMany(fetch = FetchType.EAGER,targetEntity = Acteur.class)			//many to many bidirectionnel AVEC Map et AVEC Role
	@JoinTable(name="film_acteur",
		joinColumns = @JoinColumn(name="fk_acteur"),
		inverseJoinColumns = @JoinColumn(name="fk_film"))
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
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((civilite == null) ? 0 : civilite.hashCode());
//		result = prime * result + ((dateDeces == null) ? 0 : dateDeces.hashCode());
//		result = prime * result + ((dateNaissance == null) ? 0 : dateNaissance.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
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
		Acteur other = (Acteur) obj;
		if (civilite == null) {
			if (other.civilite != null)
				return false;
		} else if (!civilite.equals(other.civilite))
			return false;
//		if (dateDeces == null) {
//			if (other.dateDeces != null)
//				return false;
//		} else if (!dateDeces.equals(other.dateDeces))
//			return false;
//		if (dateNaissance == null) {
//			if (other.dateNaissance != null)
//				return false;
//		} else if (!dateNaissance.equals(other.dateNaissance))
//			return false;
		if (id != other.id)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}
	
	
	
}
