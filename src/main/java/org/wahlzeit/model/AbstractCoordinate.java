/**
 * 
 */
package org.wahlzeit.model;
import static org.wahlzeit.utils.Assertions.*;

import org.wahlzeit.utils.exceptions.IllegalCoordinateException;


public abstract class AbstractCoordinate implements Coordinate {

	//sets maximal distance between two coordinates, so that they can still be considered equal
	private static final double MAXDISTANCE = 0.5;
	
	/* (non-Javadoc)
	 * @see org.wahlzeit.model.Coordinate#asCartesianCoordinate()
	 */
	@Override
	public abstract CartesianCoordinate asCartesianCoordinate() throws IllegalCoordinateException;
	

	public double getCartesianDistance(Coordinate coord) throws IllegalCoordinateException{
		assertClassInvariants();
		//preconditions
		assert(coord != null);
		
		double ret = doGetCartesianDistance(coord);
		
		//postconditions
		assert(ret >= 0);
		
		assertClassInvariants();
		return ret;
	}
	
	private double doGetCartesianDistance(Coordinate coord) throws IllegalCoordinateException {
		//CartesianCoordinate reimplements this method
		return coord.asCartesianCoordinate().getCartesianDistance(this);
	}

	/* (non-Javadoc)
	 * @see org.wahlzeit.model.Coordinate#asSphericCoordinate()
	 */
	@Override
	public abstract SphericCoordinate asSphericCoordinate() throws IllegalCoordinateException;
	
	/* (non-Javadoc)
	 * @see org.wahlzeit.model.Coordinate#getSphericDistance(org.wahlzeit.model.Coordinate)
	 * SphericCoordinate reimplements this method
	 */
	@Override
	public double getSphericDistance(Coordinate coord) throws IllegalCoordinateException {
		assertClassInvariants();
		//preconditions
		assert(coord != null);
		
		double ret = doGetSphericDistance(coord);
		
		//postconditions
		assert(ret >= 0);
				
		assertClassInvariants();
		return ret;
	}
	
	private double doGetSphericDistance(Coordinate coord) throws IllegalCoordinateException {
		//SphericCoordinate reimplements this method
		return coord.asSphericCoordinate().getSphericDistance(this);
	}

	/* (non-Javadoc)
	 * @see org.wahlzeit.model.Coordinate#getDistance(org.wahlzeit.model.Coordinate)
	 * using cartesianDistance to allow unified comparisons
	 */
	@Override
	public double getDistance(Coordinate coord) throws IllegalCoordinateException {
		return getCartesianDistance(coord);
	}
	
	/*
	 * @methodtype Assertion
	 */
	protected abstract void assertClassInvariants() throws IllegalCoordinateException;

	/* (non-Javadoc)
	 * @see org.wahlzeit.model.Coordinate#isEqual(org.wahlzeit.model.Coordinate)
	 */
	@Override
	public boolean isEqual(Coordinate coord) throws IllegalCoordinateException {
		assertNotNull(coord, "Coordinate should not be null!");
		if(coord.getDistance(this) > MAXDISTANCE) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * @methodtype compare 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		try {
			return isEqual((Coordinate) obj);
		} catch (IllegalCoordinateException e) {
			// TODO figure out, what to do here
			return false;
		}
	}
	

	/**
	 * @methodtype conversion
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return toString().hashCode();
	}

}
