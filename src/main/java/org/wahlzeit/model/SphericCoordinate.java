/*
* SphericCoordinate
*
* Version: 1.0
*
* Date: 20.11.17
*
*/

package org.wahlzeit.model;


public class SphericCoordinate implements Coordinate {

	private double latitude;
	private double longitude;
	private double radius;

	static final double EPSILON = 0.0001;

	/**@methodtype constructor
	 * 
	 */
	public SphericCoordinate() {
		// do nothing
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
	 * @see org.wahlzeit.model.Coordinate#getCartesianDistance(org.wahlzeit.model.
	 * Coordinate)
	 */
	@Override
	public double getCartesianDistance(Coordinate coord) {
		return getDistance(coord);
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
	 * @metodtype get
	 * 
	 * @see org.wahlzeit.model.Coordinate#getSphericDistance()
	 */
	@Override
	public double getSphericDistance(Coordinate coord) {
		return getDistance(coord);
	}

	/**
	 * @methodtype get
	 * 
	 * @see org.wahlzeit.model.Coordinate#getDistance(org.wahlzeit.model.Coordinate)
	 */
	@Override
	public double getDistance(Coordinate coord) {
		CartesianCoordinate cartesianCoordinate = coord.asCartesianCoordinate();

		return cartesianCoordinate.getDistance(this);
	}

	/**
	 * @methodtype compare)
	 * 
	 * @see org.wahlzeit.model.Coordinate#isEqual(org.wahlzeit.model.Coordinate)
	 */
	@Override
	public boolean isEqual(Coordinate coord) {

		if (coord == null) {
			return false;
		}
		SphericCoordinate other = coord.asSphericCoordinate();
		if (Math.abs(radius - other.radius) > EPSILON) {
			return false;
		}
		if (Math.abs(longitude - other.longitude) > EPSILON) {
			return false;
		}
		if (Math.abs(latitude - other.latitude) > EPSILON) {
			return false;
		}

		return true;
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
	 * @methodtype compare
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SphericCoordinate other = (SphericCoordinate) obj;
		return isEqual(other);
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

}
