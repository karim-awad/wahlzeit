package org.wahlzeit.model;

import static org.wahlzeit.utils.Assertions.*;

import org.wahlzeit.utils.exceptions.IllegalOwlException;

import com.google.appengine.api.memcache.InvalidValueException;

public class Owl {
	
	private String name;
	private int age;
	private Gender gender;
	
	private Species species;
	private Color color;
	
	public Owl(String name, int age, Gender gender, Species species, Color color) throws IllegalOwlException {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.species = species;
		this.color = color;
		
		assertClassInvariants();
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
	 * @throws IllegalOwlException 
	 * @methodtype set	 
	 */
	public void setName(String name) throws IllegalOwlException {
		this.name = name;
		assertClassInvariants();
	}

	/**
	 * @methodtype get
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @throws IllegalOwlException 
	 * @methodtype set	 
	 */
	public void setAge(int age) throws IllegalOwlException {
		this.age = age;
		assertClassInvariants();
	}

	/**
	 * @methodtype get
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * @throws IllegalOwlException 
	 * @methodtype set	 
	 */
	public void setGender(Gender gender) throws IllegalOwlException {
		this.gender = gender;
		assertClassInvariants();
	}

	/**
	 * @methodtype get
	 */
	public Species getSpecies() {
		return species;
	}

	/**
	 * @throws IllegalOwlException 
	 * @methodtype set	 
	 */
	public void setSpecies(Species species) throws IllegalOwlException {
		this.species = species;
		assertClassInvariants();
	}

	/**
	 * @methodtype get
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @throws IllegalOwlException 
	 * @methodtype set	 
	 */
	public void setColor(Color color) throws IllegalOwlException {
		this.color = color;
		assertClassInvariants();
	}
	
	private void assertClassInvariants() throws IllegalOwlException {
		try{
			assertValidString(name, "Don't treat the owl like an object, give her a name!");
			assertPositive(age, "How can a photo show an owl that is not born yet?");
			assertNotNull(gender, "The owl should have a valid gender!");
			assertNotNull(species, "The owl should have a species!");
			assertNotNull(color, "The owl sould have a clolor!");
		}catch(InvalidValueException e) {
			throw new IllegalOwlException("Illegal state of owl object: " + e.getMessage());
		}
	}

}