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

public class SphericCoordinate extends AbstractCoordinate {

	private double latitude;
	private double longitude;
	private double radius;

	static final double EPSILON = 0.0001;

	/**@methodtype constructor
	 * 
	 */
	public SphericCoordinate() {
		longitude = 0.0;
		latitude = 0.0;
		radius = 0.0;
		
		assertClassInvariants();
	}

	public SphericCoordinate(double latitude, double longitude, double radius) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
		
		assertClassInvariants();
	}

	/**
	 * @methodtype conversion
	 * 
	 * @see org.wahlzeit.model.Coordinate#asCartesianCoordinate()
	 */
	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		assertClassInvariants();
		
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
		assertClassInvariants();
		return this;
	}


	/**
	 * @methodtype get
	 * 
	 * @see org.wahlzeit.model.Coordinate#getDistance(org.wahlzeit.model.Coordinate)
	 */
	@Override
	public double getSphericDistance(Coordinate coord) {
		assertClassInvariants();
		assertNotNull(coord, "Coordinate should not be null!");
		
		double ret = doGetSphericDistance(coord);
		
		assertValidDistance(ret, "Invalid Distance!");
		assertClassInvariants();
		
		return ret;
	}
	
	private double doGetSphericDistance(Coordinate coord) {
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
		assertClassInvariants();
		return latitude;
	}

	/**
	 * @methodtype set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
		assertClassInvariants();
	}

	/**
	 * @methodtype get
	 */
	public double getLongitude() {
		assertClassInvariants();
		return longitude;
	}

	/**
	 * @methodtype set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
		assertClassInvariants();
	}

	/**
	 * @methodtype get
	 */
	public double getRadius() {
		assertClassInvariants();
		return radius;
	}

	/**
	 * @methodtype set
	 */
	public void setRadius(double radius) {
		this.radius = radius;
		assertClassInvariants();
	}

	/**
	 * @methodtype conversion
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		assertClassInvariants();
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(radius);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/**
	 * @methodtype conversion
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		assertClassInvariants();
		return "SphericCoordinate [latitude=" + latitude + ", longitude=" + longitude + ", radius=" + radius + "]";
	}

	/* (non-Javadoc)
	 * @see org.wahlzeit.model.AbstractCoordinate#assertClassInvariants()
	 */
	@Override
	public void assertClassInvariants() {
		//TODO isangular
		if(longitude < 0 || latitude < 0 || radius < 0) {
			throw new IllegalStateException();
		};

	}

}
