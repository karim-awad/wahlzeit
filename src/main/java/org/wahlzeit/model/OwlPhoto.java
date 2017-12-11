/**
 * 
 */
package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Entity;

@Entity
public class OwlPhoto extends Photo {

	private Owl owl;
	/**
	 * 
	 */
	public OwlPhoto() {
		super();
	}
	/**
	 * @param myId
	 */
	public OwlPhoto(PhotoId myId) {
		super(myId);
	}
	
	/**
	 * @methodtype get
	 * @methodproperty primitive
	 */
	public Owl getOwl() {
		return owl;
	}
	/**
	 * @methodtype set	 
	 * @methodproperty primitive
	 */
	public void setOwl(Owl owl) {
		this.owl = owl;
	}

}
