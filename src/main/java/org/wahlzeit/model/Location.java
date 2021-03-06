/*
* Location
*
* Version: 1.0
*
* Date: 28.10.17
*
*/
package org.wahlzeit.model;

import static org.wahlzeit.utils.Assertions.assertNotNull;

public class Location {
	
	public Coordinate coordinate;
	
	public Location() {
	}

	public Location(Coordinate coordinate){
		assertNotNull(coordinate, "Coordinate should not be null!");
		this.coordinate = coordinate;
	}
	
	public Coordinate getCoordinate() {
		return coordinate;
	}
	
	public void setCoordinate(Coordinate coordinate) {
		assertNotNull(coordinate, "Coordinate should not be null!");
		this.coordinate = coordinate;
	}

	@Override
	public String toString() {
		return "Location [" + coordinate.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coordinate == null) ? 0 : coordinate.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (coordinate == null) {
			if (other.coordinate != null)
				return false;
		} else if (!coordinate.equals(other.coordinate))
			return false;
		return true;
	}

}
