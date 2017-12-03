/*
* Coordinate
*
* Version: 1.0
*
* Date: 28.10.17
*
*/

package org.wahlzeit.model;

public class CartesianCoordinate extends AbstractCoordinate{

	private double x;
	private double y;
	private double z;
	
	/**@methodtype constructor
	 * 
	 */
	public CartesianCoordinate() {
		x = 0.0;
		y = 0.0;
		z = 0.0;
	}

	/**@methodtype constructor
	 * 
	 */
	public CartesianCoordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	

	/**@methodtype get
	 * 
	 */
	@Override
	public double getCartesianDistance(Coordinate coordinate) {
		assert(coordinate != null);
		CartesianCoordinate cartesianCoordinate = coordinate.asCartesianCoordinate();
		double _x = cartesianCoordinate.getX();
		double _y = cartesianCoordinate.getY();
		double _z = cartesianCoordinate.getZ();

		double xDist = Math.abs(_x - x);
		double yDist = Math.abs(_y - y);
		double zDist = Math.abs(_z - z);

		double xyzDist = Math.sqrt(Math.pow(xDist, 2.0) + Math.pow(yDist, 2.0) + Math.pow(zDist, 2.0));

		return xyzDist;
	}
	
	/**
	 * @methodtype get 
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * @methodtype get 
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * @methodtype get 
	 */
	public double getZ() {
		return z;
	}
	/**
	 * @methodtype set 
	 */
	public void setX(double x) {
		this.x = x;
	}
	
	/**
	 * @methodtype set 
	 */
	public void setY(double y) {
		this.y = y;
	}
	
	/**
	 * @methodtype set 
	 */
	public void setZ(double z) {
		this.z = z;
	}
	

	/**
	 * @methodtype conversion 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(z);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	

	
	/**
	 * @methodtype conversion
	 */
	@Override
	public String toString() {
		return "CartesianCoordinate [x=" + x + ", y=" + y + ", z=" + z + "]";
	}

	/**
	 * @methodtype conversion
	 */
	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		return this;
	}


	/**
	 * @methodtype conversion
	 * @see org.wahlzeit.model.Coordinate#getSphericCoordinate()
	 */
	@Override
	public SphericCoordinate asSphericCoordinate() {
		double radius = Math.sqrt(Math.pow(x, 2.0) + Math.pow(y, 2.0) + Math.pow(z, 2.0));
		if(radius == 0) {
			return new SphericCoordinate(0, 0, 0);
		}
		double latitude = Math.acos(z/radius);
		double longitude = Math.atan2(y, x);
		
		return new SphericCoordinate(latitude, longitude, radius);
	}

}
