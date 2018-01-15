/**
 * 
 */
package org.wahlzeit.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.wahlzeit.services.ObjectManager;
import org.wahlzeit.utils.exceptions.IllegalOwlException;

public class OwlManager extends ObjectManager {

	protected static final OwlManager instance = new OwlManager();
	
	/**
	 * In-memory caches for Owls and Owltypes
	 */
	protected List<Owl> owls = new ArrayList<Owl>();
	protected HashMap<String, OwlType> types = new HashMap<String, OwlType>();

	/**
	 * @methodtype constructor
	 */
	private OwlManager() {}
	
	/**
	 * @methodtype get
	 */
	public static OwlManager getInstance(){
		return instance;
	}
	
	
	public Owl createOwl(String typeName, String name, int age) throws IllegalOwlException {
		if(typeName == null) throw new IllegalArgumentException();
		OwlType type = getOwlType(typeName);
		Owl result = type.createInstance(name, age);
		owls.add(result);
		
		return result;
	}
	
	/**
	 * @methodtype get
	 */
	public OwlType getOwlType(String typeName) {
		OwlType ret = types.get(typeName);
		if(ret == null) {
			ret = new OwlType(typeName);
			types.put(typeName, ret);
		}
		return ret;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OwlManager [types=" + types + "]";
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
		OwlManager other = (OwlManager) obj;
		if (types == null) {
			if (other.types != null)
				return false;
		} else if (!types.equals(other.types))
			return false;
		return true;
	}
	
	

}
