/**
 * 
 */
package org.wahlzeit.model;

import static org.junit.Assert.assertNotNull;

/**
 * @author karim
 *
 */
public abstract class AbstractCoordinate implements Coordinate {

	//sets maximal distance between two coordinates, so that they can still be considered equal
	private static final double MAXDISTANCE = 0.5;
	
	/* (non-Javadoc)
	 * @see org.wahlzeit.model.Coordinate#asCartesianCoordinate()
	 */
	@Override
	public abstract CartesianCoordinate asCartesianCoordinate();
	

	public double getCartesianDistance(Coordinate coord) {
		assertClassInvariants();
		//preconditions
		assertNotNull(coord);
		
		double ret = doGetCartesianDistance(coord);
		
		//postconditions
		assert(ret >= 0);
		
		assertClassInvariants();
		return ret;
	}
	
	private double doGetCartesianDistance(Coordinate coord) {
		//CartesianCoordinate reimplements this method
		return coord.asCartesianCoordinate().getCartesianDistance(this);
	}

	/* (non-Javadoc)
	 * @see org.wahlzeit.model.Coordinate#asSphericCoordinate()
	 */
	@Override
	public abstract SphericCoordinate asSphericCoordinate();
	
	/* (non-Javadoc)
	 * @see org.wahlzeit.model.Coordinate#getSphericDistance(org.wahlzeit.model.Coordinate)
	 * SphericCoordinate reimplements this method
	 */
	@Override
	public double getSphericDistance(Coordinate coord) {
		assertClassInvariants();
		//preconditions
		assertNotNull(coord);
		
		double ret = doGetSphericDistance(coord);
		
		//postconditions
		assert(ret >= 0);
				
		assertClassInvariants();
		return ret;
	}
	
	private double doGetSphericDistance(Coordinate coord) {
		//SphericCoordinate reimplements this method
		return coord.asSphericCoordinate().getSphericDistance(this);
	}

	/* (non-Javadoc)
	 * @see org.wahlzeit.model.Coordinate#getDistance(org.wahlzeit.model.Coordinate)
	 * using cartesianDistance to allow unified comparisons
	 */
	@Override
	public double getDistance(Coordinate coord) {
		return getCartesianDistance(coord);
	}
	
	/* (non-Javadoc)
	* @see org.wahlzeit.model.Coordinate#assertClassInvariants()
	*/
	@Override
	public abstract void assertClassInvariants();

	/* (non-Javadoc)
	 * @see org.wahlzeit.model.Coordinate#isEqual(org.wahlzeit.model.Coordinate)
	 */
	@Override
	public boolean isEqual(Coordinate coord) {
		if(coord == null) {
			return false;
		}
		
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

		return isEqual((Coordinate) obj);
	}

}
