/**
 * 
 */
package org.wahlzeit.model;

import org.wahlzeit.services.ObjectManager;
import com.google.appengine.api.datastore.Key;
import com.googlecode.objectify.annotation.Subclass;

/**
 * @author Karim Awad
 *
 */
@Subclass
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
