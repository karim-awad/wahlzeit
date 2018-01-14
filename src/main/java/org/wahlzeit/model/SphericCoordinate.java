/*
* SphericCoordinate
*
* Version: 1.0
*
* Date: 20.11.17
*
*/

package org.wahlzeit.model;

import static org.wahlzeit.utils.Assertions.*;

import java.util.Hashtable;
import org.wahlzeit.utils.exceptions.IllegalCoordinateException;
import com.google.appengine.api.memcache.InvalidValueException;
import com.googlecode.objectify.annotation.Subclass;

@Subclass
public class SphericCoordinate extends AbstractCoordinate {
	
	protected static Hashtable<Integer, SphericCoordinate> sharedCoordinates = new Hashtable<Integer, SphericCoordinate>(); 
	
	private final double latitude;
	private final double longitude;
	private final double radius;

	static final double EPSILON = 0.0001;

	public static SphericCoordinate getSphericCoordinate(double latitude, double longitude, double radius) throws IllegalCoordinateException {
		SphericCoordinate retCoor = new SphericCoordinate(latitude, longitude, radius);
		SphericCoordinate sharedCoordinate = sharedCoordinates.get(retCoor.hashCode());
		if(sharedCoordinate == null) {
			sharedCoordinates.put(retCoor.hashCode(), retCoor);
			return retCoor;
		}
		return sharedCoordinate;
	}
	
	public static SphericCoordinate getSphericCoordinate(double latitude, double longitude) throws IllegalCoordinateException {
		SphericCoordinate retCoor = new SphericCoordinate(latitude, longitude);
		SphericCoordinate sharedCoordinate = sharedCoordinates.get(retCoor.hashCode());
		if(sharedCoordinate == null) {
			sharedCoordinates.put(retCoor.hashCode(), retCoor);
			return retCoor;
		}
		return sharedCoordinate;
	}
	
	/**@throws IllegalCoordinateException 
	 * @methodtype constructor
	 * 
	 */
	private SphericCoordinate(double latitude, double longitude, double radius) throws IllegalCoordinateException {
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
				
		assertClassInvariants();
	}

	/**@throws IllegalCoordinateException 
	 * @methodtype constructor
	 * 
	 */
	private SphericCoordinate(double latitude, double longitude) throws IllegalCoordinateException {
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = 6370; //Earthradius
				
		assertClassInvariants();
	}
	/**
	 * @throws IllegalCoordinateException 
	 * @methodtype conversion
	 * 
	 * @see org.wahlzeit.model.Coordinate#asCartesianCoordinate()
	 */
	@Override
	public CartesianCoordinate asCartesianCoordinate() throws IllegalCoordinateException {
		
		double x = radius * Math.sin(latitude) * Math.cos(longitude);
		double y = radius * Math.sin(latitude) * Math.sin(longitude);
		double z = radius * Math.cos(latitude);

		return CartesianCoordinate.getCartesianCoordinate(x, y, z);
	}

	/**
	 * @methodtype get
	 * 
	 * @see org.wahlzeit.model.Coordinate#asSphericCoordinate()
	 */
	@Override
	public SphericCoordinate asSphericCoordinate() {
		return this;
	}


	/**
	 * @throws IllegalCoordinateException 
	 * @methodtype get
	 * 
	 * @see org.wahlzeit.model.Coordinate#getDistance(org.wahlzeit.model.Coordinate)
	 */
	@Override
	public double getSphericDistance(Coordinate coord) throws IllegalCoordinateException {
		assertClassInvariants();
		assertNotNull(coord, "Coordinate should not be null!");
		
		double ret = doGetSphericDistance(coord);
		
		assertValidDistance(ret, "Invalid Distance!");
		assertClassInvariants();
		return ret;
	}
	
	private double doGetSphericDistance(Coordinate coord) throws IllegalCoordinateException {
		SphericCoordinate spherCoord = coord.asSphericCoordinate();
		double latitude = Math.toRadians(this.latitude);
		double longitude = Math.toRadians(this.longitude);
		double otherLatitude = Math.toRadians(spherCoord.getLatitude());
		double otherLongitude = Math.toRadians(spherCoord.getLongitude());
		
		//formula to calculate angle according to Wikipedia
		double angle = Math.acos(Math.sin(latitude) * Math.sin(otherLatitude) 
							+ Math.cos(latitude) * Math.cos(otherLatitude)
									* Math.cos(otherLongitude - longitude));
		
		return angle * radius;
	}


	/**
	 * @methodtype get
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @methodtype get
	 */
	public double getLongitude() {
		return longitude;
	}


	/**
	 * @methodtype get
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * @methodtype conversion
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SphericCoordinate [latitude=" + latitude + ", longitude=" + longitude + ", radius=" + radius + "]";
	}
	

	/* (non-Javadoc)
	 * @see org.wahlzeit.model.AbstractCoordinate#assertClassInvariants()
	 */
	@Override
	public void assertClassInvariants() throws IllegalCoordinateException {
		if(longitude < 0 || latitude < 0 || radius < 0) {
			throw new IllegalCoordinateException("Invalid state of spheric Coordinate!");
		};
		try {		
			assertValidDouble(longitude, "Invalid longitude!");
			assertValidDouble(latitude, "Invalid latitude!");
			assertValidDouble(radius, "Invalid radius!");
		}
		catch(InvalidValueException e) {
			throw new IllegalCoordinateException("Illegal state of spheric coordinate!");
		}

	}

}
