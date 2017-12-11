/*
* Coordinate
*
* Version: 1.0
*
* Date: 20.11.17
*
*/

package org.wahlzeit.model;

import org.wahlzeit.utils.exceptions.IllegalCoordinateException;

public interface Coordinate {

	/**
	 * @throws IllegalCoordinateException 
	 * @methodtype Conversion
	 * returns Coordinate in form of a CartesianCoordinate
	 */
	public CartesianCoordinate asCartesianCoordinate() throws IllegalCoordinateException;
	
	/** 
	 * @throws IllegalCoordinateException 
	 * @methodtype get
	 * returns Distance between two coordinates
	 */
	public double getCartesianDistance(Coordinate coord) throws IllegalCoordinateException;
	
	/**
	 *  @throws IllegalCoordinateException 
	 * @methodtype get
	 * returns Coordinate in form of a SphericCoordinate
	 */
	public SphericCoordinate asSphericCoordinate() throws IllegalCoordinateException;
	
	/** 
	 * @throws IllegalCoordinateException 
	 * @methodtype get
	 * returns Distance between two coordinates
	 */
	public double getSphericDistance(Coordinate coord) throws IllegalCoordinateException;
	
	/** 
	 * @throws IllegalCoordinateException 
	 * @methodtype get
	 * returns Distance between two coordinates
	 */
	public double getDistance(Coordinate coord) throws IllegalCoordinateException;
	
	/** 
	 * @throws IllegalCoordinateException 
	 * @methodtype Compare
	 * 
	 * tests equality of coordinates
	 */
	public boolean isEqual(Coordinate coord) throws IllegalCoordinateException;

}
