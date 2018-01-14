package org.wahlzeit.model;

import java.util.logging.Logger;

import org.wahlzeit.services.LogBuilder;
import org.wahlzeit.utils.PatternInstance;

import com.googlecode.objectify.annotation.Subclass;

/**
 * An Factory for creating photos of owls and related objects.
 * Uses singleton pattern, to guarantee that only one instance exists
 */
@PatternInstance(
		patternName = "Factory",
		participants = {"OwlPhotoFactory", "OwlPhoto"}
		)

@Subclass
public class OwlPhotoFactory extends PhotoFactory {

	protected OwlPhotoFactory() {
		super();
	}
	
	private static final Logger log = Logger.getLogger(OwlPhotoFactory.class.getName());
	/**
	 * Hidden singleton instance; needs to be initialized from the outside.
	 */
	private static OwlPhotoFactory instance = null;

	/**
	 * @methodtype get	 
	 * @methodproperty primitive
	 */
	@PatternInstance(
			patternName = "Singleton",
			participants = {"PhotoFactory"})
	public static synchronized OwlPhotoFactory getInstance() {
		if (instance == null) {
			log.config(LogBuilder.createSystemMessage().addAction("setting generic OwlPhotoFactory").toString());
			setInstance(new OwlPhotoFactory());
		}

		return instance;
	}

	/**
	 * @methodtype set	 
	 * @methodproperty primitive
	 */
	protected static synchronized void setInstance(OwlPhotoFactory owlPhotoFactory) {
		if (instance != null) {
			throw new IllegalStateException("attempt to initalize OwlPhotoFactory twice");
		}

		instance = owlPhotoFactory;
	}

	/**
	 * @methodtype factory
	 */
	public OwlPhoto createPhoto() {
		return new OwlPhoto();
	}

	/**
	 * Creates a new photo with the specified id
	 * @methodtype factory
	 */
	public OwlPhoto createPhoto(PhotoId id) {
		return new OwlPhoto(id);
	}


}
