/*
* Coordinate
*
* Version: 1.0
*
* Date: 20.11.17
*
*/

package org.wahlzeit.model;


public interface Coordinate {

	/**
	 * @methodtype Conversion
	 * returns Coordinate in form of a CartesianCoordinate
	 */
	public CartesianCoordinate asCartesianCoordinate();
	
	/** 
	 * @methodtype get
	 * returns Distance between two coordinates
	 */
	public double getCartesianDistance(Coordinate coord);
	
	/**
	 *  @methodtype get
	 * returns Coordinate in form of a SphericCoordinate
	 */
	public SphericCoordinate asSphericCoordinate();
	
	/** 
	 * @methodtype get
	 * returns Distance between two coordinates
	 */
	public double getSphericDistance(Coordinate coord);
	
	/** 
	 * @methodtype get
	 * returns Distance between two coordinates
	 */
	public double getDistance(Coordinate coord);
	
	/** 
	 * @methodtype Compare
	 * 
	 * tests equality of coordinates
	 */
	public boolean isEqual(Coordinate coord);

}
