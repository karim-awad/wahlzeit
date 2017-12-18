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
import org.wahlzeit.utils.exceptions.IllegalCoordinateException;

import com.google.appengine.api.memcache.InvalidValueException;

public class SphericCoordinate extends AbstractCoordinate {

	private final double latitude;
	private final double longitude;
	private final double radius;

	static final double EPSILON = 0.0001;

	/**@throws IllegalCoordinateException 
	 * @methodtype constructor
	 * 
	 */
	public SphericCoordinate() throws IllegalCoordinateException {
		longitude = 0.0;
		latitude = 0.0;
		radius = 0.0;
		
		assertClassInvariants();
	}

	public SphericCoordinate(double latitude, double longitude, double radius) throws IllegalCoordinateException {
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
		
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

		return new CartesianCoordinate(x, y, z);
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
	 * @throws IllegalCoordinateException 
	 * @methodtype set
	 */
	public SphericCoordinate setLatitude(double latitude) throws IllegalCoordinateException {
		return new SphericCoordinate(latitude, longitude, radius);
	}

	/**
	 * @methodtype get
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @throws IllegalCoordinateException 
	 * @methodtype set
	 */
	public SphericCoordinate setLongitude(double longitude) throws IllegalCoordinateException {
		return new SphericCoordinate(latitude, longitude, radius);
	}

	/**
	 * @methodtype get
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * @throws IllegalCoordinateException 
	 * @methodtype set
	 */
	public SphericCoordinate setRadius(double radius) throws IllegalCoordinateException {
		return new SphericCoordinate(latitude, longitude, radius);
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
