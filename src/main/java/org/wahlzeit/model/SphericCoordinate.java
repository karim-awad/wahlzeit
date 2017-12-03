/*
* SphericCoordinate
*
* Version: 1.0
*
* Date: 20.11.17
*
*/

package org.wahlzeit.model;


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
	}

	public SphericCoordinate(double latitude, double longitude, double radius) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
	}

	/**
	 * @methodtype conversion
	 * 
	 * @see org.wahlzeit.model.Coordinate#asCartesianCoordinate()
	 */
	@Override
	public CartesianCoordinate asCartesianCoordinate() {
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
	 * @methodtype get
	 * 
	 * @see org.wahlzeit.model.Coordinate#getDistance(org.wahlzeit.model.Coordinate)
	 */
	@Override
	public double getSphericDistance(Coordinate coord) {
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
	 * @methodtype set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @methodtype get
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @methodtype set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @methodtype get
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * @methodtype set
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}

	/**
	 * @methodtype conversion
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
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
		return "SphericCoordinate [latitude=" + latitude + ", longitude=" + longitude + ", radius=" + radius + "]";
	}

	/* (non-Javadoc)
	 * @see org.wahlzeit.model.AbstractCoordinate#assertClassInvariants()
	 */
	@Override
	public void assertClassInvariants() {
		assert(longitude >= 0);
		assert(latitude >= 0);
		assert(radius >= 0);
	}

}
