/*
* Location
*
* Version: 1.0
*
* Date: 28.10.17
*
*/
package org.wahlzeit.model;

public class Location {
	
	public CartesianCoordinate cartesianCoordinate;
	
	public Location() {
		this.cartesianCoordinate = null;
	}

	public Location(CartesianCoordinate cartesianCoordinate){
		this.cartesianCoordinate = cartesianCoordinate;
	}
	
	public CartesianCoordinate getCoordinate() {
		return cartesianCoordinate;
	}
	
	public void setCoordinate(CartesianCoordinate cartesianCoordinate) {
		this.cartesianCoordinate = cartesianCoordinate;
	}

	@Override
	public String toString() {
		return "Location [" + cartesianCoordinate.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cartesianCoordinate == null) ? 0 : cartesianCoordinate.hashCode());
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
		if (cartesianCoordinate == null) {
			if (other.cartesianCoordinate != null)
				return false;
		} else if (!cartesianCoordinate.equals(other.cartesianCoordinate))
			return false;
		return true;
	}
}
