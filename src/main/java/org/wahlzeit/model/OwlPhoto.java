/**
 * 
 */
package org.wahlzeit.model;

import org.wahlzeit.utils.exceptions.IllegalCoordinateException;

import com.googlecode.objectify.annotation.Subclass;

@Subclass
public class OwlPhoto extends Photo {
	public final static String OWLNAME = "OwlName";
	public final static String OWLAGE = "OwlAge";
	public final static String OWLSPECIES = "OwlSpecies";
	public final static String LocationLongitude = "LocationLongitude";
	public final static String LocationLatitude = "LocationLatitude";


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
	 */
	public String getCaption(ModelConfig cfg) {
		String ownerName = UserManager.getInstance().getUserById(ownerId).getNickName();
		String ret;
		try {
			ret = cfg.asPhotoCaption(ownerName, owl, location);
		}
		catch(IllegalCoordinateException e) {
			ret = "Unable to generate caption!";
		}
		return ret;
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
