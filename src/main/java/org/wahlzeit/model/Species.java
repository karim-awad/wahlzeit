/**
 * 
 */
package org.wahlzeit.model;

/**
 * @author Karim Awad
 *
 */

public class Species {

	private String name;
	private String family;
	private boolean endangered;
	
	
	public Species() {
		
	}
	/**
	 * @param name
	 * @param family
	 * @param endangered
	 */
	public Species(String name, String family, boolean endangered) {
		this.name = name;
		this.family = family;
		this.endangered = endangered;
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
	 * @methodtype set	 
	 * @methodproperty primitive
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @methodtype get
	 * @methodproperty primitive
	 */
	public String getFamily() {
		return family;
	}
	/**
	 * @methodtype set	 
	 * @methodproperty primitive
	 */
	public void setFamily(String family) {
		this.family = family;
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
	 * 
	 */

}
