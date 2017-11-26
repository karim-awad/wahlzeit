/**
 * 
 */
package org.wahlzeit.model;

/**
 * @author karim
 *
 */
public abstract class AbstractCoordinate implements Coordinate {

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
		return coord.asCartesianCoordinate().getDistance(this);
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
		return coord.asSphericCoordinate().getDistance(this);
	}

	/* (non-Javadoc)
	 * @see org.wahlzeit.model.Coordinate#getDistance(org.wahlzeit.model.Coordinate)
	 */
	@Override
	public abstract double getDistance(Coordinate coord);

	/* (non-Javadoc)
	 * @see org.wahlzeit.model.Coordinate#isEqual(org.wahlzeit.model.Coordinate)
	 */
	@Override
	public abstract boolean isEqual(Coordinate coord);

}
