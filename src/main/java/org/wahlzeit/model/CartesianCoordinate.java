/*
* Coordinate
*
* Version: 1.0
*
* Date: 28.10.17
*
*/

package org.wahlzeit.model;

import static org.wahlzeit.utils.Assertions.*;

import java.util.Hashtable;
import org.wahlzeit.utils.exceptions.IllegalCoordinateException;
import com.google.appengine.api.memcache.InvalidValueException;
import com.googlecode.objectify.annotation.Subclass;

@Subclass
public class CartesianCoordinate extends AbstractCoordinate{
	
	protected static Hashtable<Integer, CartesianCoordinate> sharedCoordinates = new Hashtable<Integer, CartesianCoordinate>(); 

	private final double x;
	private final double y;
	private final double z;
	
	public static CartesianCoordinate getCartesianCoordinate(double x, double y, double z) throws IllegalCoordinateException {
		CartesianCoordinate retCoordinate = new CartesianCoordinate(x, y, z);
		CartesianCoordinate sharedCoordinate = sharedCoordinates.get(retCoordinate.hashCode());
		
		if(sharedCoordinate == null) {
			sharedCoordinates.put(retCoordinate.hashCode(), retCoordinate);
			return retCoordinate;
		}
		
		return sharedCoordinate;
	}
	
	/**@throws IllegalCoordinateException 
	 * @methodtype constructor
	 * 
	 */
	private CartesianCoordinate(double x, double y, double z) throws IllegalCoordinateException {
		this.x = x;
		this.y = y;
		this.z = z;
				
		assertClassInvariants();
	}
	

	/**@throws IllegalCoordinateException 
	 * @methodtype get
	 * 
	 */
	@Override
	public double getCartesianDistance(Coordinate coordinate) throws IllegalCoordinateException {
		assertClassInvariants();
		assertNotNull(coordinate, "Coordinate should not be null!");
		
		double ret = doGetCartesianCoordinate(coordinate);
		
		assertValidDistance(ret, "Invalid Distance!");	
		assertClassInvariants();
		return ret;
	}
	
	private double doGetCartesianCoordinate(Coordinate coordinate) throws IllegalCoordinateException {
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
	 * @throws IllegalCoordinateException 
	 * @methodtype get 
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * @throws IllegalCoordinateException 
	 * @methodtype get 
	 */
	public double getZ(){
		return z;
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
	 * @throws IllegalCoordinateException 
	 * @methodtype conversion
	 * @see org.wahlzeit.model.Coordinate#getSphericCoordinate()
	 */
	@Override
	public SphericCoordinate asSphericCoordinate() throws IllegalCoordinateException {
		assertClassInvariants();
		double radius = Math.sqrt(Math.pow(x, 2.0) + Math.pow(y, 2.0) + Math.pow(z, 2.0));
		if(radius == 0) {
			return SphericCoordinate.getSphericCoordinate(0, 0, 0);
		}
		double latitude = Math.acos(z/radius);
		double longitude = Math.atan2(y, x);
		
		return SphericCoordinate.getSphericCoordinate(latitude, longitude, radius);
	}

	/* (non-Javadoc)
	 * @see org.wahlzeit.model.AbstractCoordinate#assertClassInvariants()
	 */
	@Override
	public void assertClassInvariants() throws IllegalCoordinateException {
		try {		
			assertValidDouble(x, "Invalid X Value!");
			assertValidDouble(y, "Invalid Y Value!");
			assertValidDouble(z, "Invalid Z Value!");
		}
		catch(InvalidValueException e) {
			throw new IllegalCoordinateException("Illegal state of coordinate!");
		}
	}

}
