package org.wahlzeit.model;

import static org.wahlzeit.utils.Assertions.*;

import org.wahlzeit.utils.exceptions.IllegalOwlException;

import com.google.appengine.api.memcache.InvalidValueException;

public class Owl {
	
	private String name;
	private int age;
	private String speciesName;
	
	public Owl(String name, int age, String speciesName) throws IllegalOwlException {
		this.name = name;
		this.age = age;
		this.speciesName = speciesName;
		
		assertClassInvariants();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Owl [name=" + name + ", age=" + age + ", species=" + speciesName + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((speciesName == null) ? 0 : speciesName.hashCode());
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (speciesName == null) {
			if (other.speciesName != null)
				return false;
		} else if (!speciesName.equals(other.speciesName))
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
	public String getSpeciesName() {
		return speciesName;
	}

	/**
	 * @throws IllegalOwlException 
	 * @methodtype set	 
	 */
	public void setSpeciesName (String speciesName) throws IllegalOwlException {
		this.speciesName = speciesName;
		assertClassInvariants();
	}

	
	private void assertClassInvariants() throws IllegalOwlException {
		try{
			assertValidString(name, "Don't treat the owl like an object, give her a name!");
			assertPositive(age, "How can a photo show an owl that is not born yet?");
			assertValidString(speciesName, "The owl should have a species!");
		}catch(InvalidValueException e) {
			throw new IllegalOwlException("Illegal state of owl object: " + e.getMessage());
		}
	}

}