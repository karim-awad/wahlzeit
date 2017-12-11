/**
 * 
 */
package org.wahlzeit.model;
import static org.wahlzeit.utils.Assertions.*;
import org.wahlzeit.utils.exceptions.IllegalSpeciesException;

import com.google.appengine.api.memcache.InvalidValueException;

/**
 * @author Karim Awad
 *
 */

public class Species {

	private String name;
	private String family;
	private boolean endangered;
	
	/**
	 * @param name
	 * @param family
	 * @param endangered
	 * @throws IllegalSpeciesException 
	 */
	public Species(String name, String family, boolean endangered) throws IllegalSpeciesException {
		this.name = name;
		this.family = family;
		this.endangered = endangered;
		
		assertClassInvariants();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Species [name=" + name + ", family=" + family + ", endangered=" + endangered + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (endangered ? 1231 : 1237);
		result = prime * result + ((family == null) ? 0 : family.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Species other = (Species) obj;
		if (endangered != other.endangered)
			return false;
		if (family == null) {
			if (other.family != null)
				return false;
		} else if (!family.equals(other.family))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/**
	 * @methodtype get	 
	 * @methodproperty primitive
	 *
	 */
	public String getName() {
		return name;
	}
	/**
	 * @throws IllegalSpeciesException 
	 * @methodtype set	 
	 * @methodproperty primitive
	 */
	public void setName(String name) throws IllegalSpeciesException {
		this.name = name;
		assertClassInvariants();
	}
	/**
	 * @methodtype get
	 * @methodproperty primitive
	 */
	public String getFamily() {
		return family;
	}
	/**
	 * @throws IllegalSpeciesException 
	 * @methodtype set	 
	 * @methodproperty primitive
	 */
	public void setFamily(String family) throws IllegalSpeciesException {
		this.family = family;
		assertClassInvariants();
	}
	/**
	 * @methodtype get
	 * @methodproperty primitive
	 */
	public boolean isEndangered() {
		return endangered;
	}
	/**
	 * @methodtype set	 
	 * @methodproperty primitive
	 */
	public void setEndangered(boolean endangered) {
		this.endangered = endangered;
	}
	/**
	 * @throws IllegalSpeciesException 
	 * @methodtype assertion
	 */
	private void assertClassInvariants() throws IllegalSpeciesException {
		try {
			assertValidString(name, "The species should not have a valid name!");
			assertValidString(family, "The species family should be valid!");
		}catch(InvalidValueException e) {
			throw new IllegalSpeciesException("Invalid Species object state: " + e.getMessage());
		}
	}

}
