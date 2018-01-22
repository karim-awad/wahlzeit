/*
* OwlType
*
* Version: 1.0
*
* Date: 14.01.18
*
*/

package org.wahlzeit.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.wahlzeit.services.DataObject;
import org.wahlzeit.utils.Assertions;
import org.wahlzeit.utils.exceptions.IllegalOwlException;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Serialize;


@Entity
public class OwlType extends DataObject {

	private static final long serialVersionUID = 6593386202045535792L;
	protected String name;
	protected OwlType superType = null;
	@Serialize
	protected Set<OwlType> subTypes = new HashSet<OwlType>();
	public OwlManager manager = OwlManager.getInstance();
	
	/**
	 * @methodtype constructor
	 */
	public OwlType(String name) {
		this.name = name;
		assertClassInvariants();
	}
	
	
	public Owl createInstance(String name, int age) throws IllegalOwlException {
		return new Owl(name, age, this);
	}
	
	
	public void addSubType(OwlType type) {
		if(type == null) throw new IllegalArgumentException();
		type.setSupertype(this);
		subTypes.add(type);
	}
	
	
	public Iterator<OwlType> getSubTypeIterator(){
		return subTypes.iterator();
	}
	
	
	public boolean hasInstance(Owl owl) {
		if(owl == null) return false;
		
		if(owl.getType() == this) {
			return true;
		}
		
		for (OwlType type : subTypes) {
			if(type.hasInstance(owl)) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * checks whether parameter is a subtype of this
	 */
	public boolean isSubtype(OwlType subtype) {
		if (subtype == null) return false;
		
		for (OwlType type : subTypes) {
			if(subtype == type || type.isSubtype(subtype)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * checks whether parameter is a supertype of this
	 */
	public boolean isSupertype(OwlType superType) {
		if (superType == null) return false;
		
		if(superType == this.superType) {
			return true;
		}else {
			return this.superType.isSupertype(superType);
		}
	}
	
	
	/**
	 * @methodtype get
	 */
	public OwlType getSupertype() {
		return superType;
	}
	

	/**
	 * @methodtype set	 
	 */
	public void setSupertype(OwlType superType) {
		this.superType = superType;
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
	 * @methodtype assertion
	 */
	public void assertClassInvariants() {
		Assertions.assertValidString(name, "Invalid Species Name");
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OwlType [name=" + name + "]";
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((manager == null) ? 0 : manager.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((subTypes == null) ? 0 : subTypes.hashCode());
		result = prime * result + ((superType == null) ? 0 : superType.hashCode());
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
		OwlType other = (OwlType) obj;
		if (manager == null) {
			if (other.manager != null)
				return false;
		} else if (!manager.equals(other.manager))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (subTypes == null) {
			if (other.subTypes != null)
				return false;
		} else if (!subTypes.equals(other.subTypes))
			return false;
		if (superType == null) {
			if (other.superType != null)
				return false;
		} else if (!superType.equals(other.superType))
			return false;
		return true;
	}

	
}
