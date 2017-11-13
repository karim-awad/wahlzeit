package org.wahlzeit.model;

public class Owl {
	
	private String name;
	private int age;
	private Gender gender;
	
	private Species species;
	private Color color;
	
	public Owl() {
		
	}
	
	public Owl(String name, int age, Gender gender, Species species, Color color) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.species = species;
		this.color = color;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Owl [name=" + name + ", age=" + age + ", gender=" + gender + ", species=" + species.toString() + ", color=" + color.asString()
				+ "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((species == null) ? 0 : species.hashCode());
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
		Owl other = (Owl) obj;
		if (age != other.age)
			return false;
		if (color != other.color)
			return false;
		if (gender != other.gender)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (species == null) {
			if (other.species != null)
				return false;
		} else if (!species.equals(other.species))
			return false;
		return true;
	}


	/**
	 * @methodtype get
	 */
	public String getName() {
		return name;
	}

	/**
	 * @methodtype set	 
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @methodtype get
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @methodtype set	 
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @methodtype get
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * @methodtype set	 
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * @methodtype get
	 */
	public Species getSpecies() {
		return species;
	}

	/**
	 * @methodtype set	 
	 */
	public void setSpecies(Species species) {
		this.species = species;
	}

	/**
	 * @methodtype get
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @methodtype set	 
	 */
	public void setColor(Color color) {
		this.color = color;
	}

}