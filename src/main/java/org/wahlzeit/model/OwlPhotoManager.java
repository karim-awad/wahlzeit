package org.wahlzeit.model;

public class OwlPhotoManager extends PhotoManager {

	protected static final OwlPhotoManager instance = new OwlPhotoManager();

	public OwlPhotoManager() {
		photoTagCollector = OwlPhotoFactory.getInstance().createPhotoTagCollector();
	}
	
	/**
	 *
	 */
	public static OwlPhotoManager getInstance() {
		return instance;
	}
	
	/**
	 *
	 */
	public Photo getPhotoFromId(PhotoId id) {
		if (id == null) {
			return null;
		}

		Photo result = doGetPhotoFromId(id);

		if (result == null) {
			result = OwlPhotoFactory.getInstance().loadPhoto(id);
			if (result != null) {
				doAddPhoto(result);
			}
		}

		return result;
	}


}
