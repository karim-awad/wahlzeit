/**
 * 
 */
package org.wahlzeit.model;

import org.wahlzeit.utils.exceptions.IllegalCoordinateException;

import com.googlecode.objectify.annotation.Serialize;
import com.googlecode.objectify.annotation.Subclass;

/**
-------------------------------------------------------------------------------
Object Instantiation							
-------------------------------------------------------------------------------
Delegation: seperate-object													
Selection: sub-classing 														
Configuration: in-code															
Instantiation: in-code															
Initialization: in-second-step 												
Building: default																
-------------------------------------------------------------------------------
Method Calls:																
-> OwlPhotoManager::createPhoto(String filename, Image uploadedImage)		
	-> PhotoUtil.createPhoto(String filename, PhotoId id, Image uploadedImage)
		-> OwlPhotoFactory::createPhoto(PhotoId id)								
			-> OwlPhoto::OwlPhoto(PhotoId id)									
-------------------------------------------------------------------------------
**/
@Subclass
public class OwlPhoto extends Photo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2510511121392525534L;
	public final static String OWLNAME = "OwlName";
	public final static String OWLAGE = "OwlAge";
	public final static String OWLSPECIES = "OwlSpecies";
	public final static String LocationLongitude = "LocationLongitude";
	public final static String LocationLatitude = "LocationLatitude";

	@Serialize
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
