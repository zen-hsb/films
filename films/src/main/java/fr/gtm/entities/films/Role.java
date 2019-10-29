package fr.gtm.entities.films;

import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name = "film_acteur")
public class Role {
	private String role;

	
	public Role() {
		super();
	}

	public Role(String role) {
		super();
		this.role = role;
	}
	
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((role == null) ? 0 : role.hashCode());
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
		Role other = (Role) obj;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}

	
	
}
