package org.wahlzeit.model;

import static org.wahlzeit.utils.Assertions.*;

import org.wahlzeit.utils.exceptions.IllegalOwlException;

import com.google.appengine.api.memcache.InvalidValueException;
import com.googlecode.objectify.annotation.Entity;

/**
---------------------------------------------------------------
Object Instantiation						 
---------------------------------------------------------------
 Delegation: seperate-object 									
 Selection: on-the-spot										 
 Configuration: in-code										 
 Instantiation: in-code										 
 Initialization: default										 
 Building: default												 
---------------------------------------------------------------
 Method Calls:													
 ->OwlManager::createOwl(String typeName, String name, int age) 
 	->OwlType::createInstance(String name, int age)				
 		->Owl::Owl(String name, int age, OwlType type)			
---------------------------------------------------------------
**/
@Entity
public class Owl{
	

	public OwlManager manager = OwlManager.getInstance();
	protected OwlType owlType = null;

	private String name;
	private int age;
	

	public Owl(String name, int age, OwlType type) throws IllegalOwlException {
		this.name = name;
		this.age = age;
		this.owlType = type;
		
		assertClassInvariants();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Owl [name=" + name + ", age=" + age + owlType.toString() + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return toString().hashCode();
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
	public OwlType getType() {
		return owlType;
	}
	
	
	/**
	 * @methodtype set
	 */
	public void setType(OwlType type) {
		this.owlType = type;
	}

	
	private void assertClassInvariants() throws IllegalOwlException {
		try{
			assertValidString(name, "Don't treat the owl like an object, give it a name!");
			assertPositive(age, "How can a photo show an owl that is not born yet?");
			assertNotNull(owlType, "Owl should have a species");
		}catch(InvalidValueException e) {
			throw new IllegalOwlException("Illegal state of owl object: " + e.getMessage());
		}
	}

}