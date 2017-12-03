/**
 * 
 */
package org.wahlzeit.model;

/**
 * @author karim
 *
 */
public abstract class AbstractCoordinate implements Coordinate {

	private static final double MINDISTANCE = 0.5;
	/* (non-Javadoc)
	 * @see org.wahlzeit.model.Coordinate#asCartesianCoordinate()
	 */
	@Override
	public abstract CartesianCoordinate asCartesianCoordinate();
	
	/* (non-Javadoc)
	 * @see org.wahlzeit.model.Coordinate#getCartesianDistance(org.wahlzeit.model.Coordinate)
	 */
	@Override
	public double getCartesianDistance(Coordinate coord) {
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
	 */
	@Override
	public double getSphericDistance(Coordinate coord) {
		//SphericCoordinate reimplements this method
		return coord.asSphericCoordinate().getSphericDistance(this);
	}

	/* (non-Javadoc)
	 * @see org.wahlzeit.model.Coordinate#getDistance(org.wahlzeit.model.Coordinate)
	 */
	@Override
	public double getDistance(Coordinate coord) {
		//using cartesianDistance to allow unified comparisons
		return getCartesianDistance(coord);
	}

	/* (non-Javadoc)
	 * @see org.wahlzeit.model.Coordinate#isEqual(org.wahlzeit.model.Coordinate)
	 */
	@Override
	public boolean isEqual(Coordinate coord) {
		if(coord == null) {
			return false;
		}
		
		if(coord.getDistance(this) > MINDISTANCE) {
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
