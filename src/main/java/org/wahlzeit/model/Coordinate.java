package org.wahlzeit.model;

public class Coordinate {
	
	private double x;
	private double y;
	private double z;
	
	public Coordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public double getDistance(Coordinate coordinate) {
		double _x = coordinate.getX();
		double _y = coordinate.getY();
		double _z = coordinate.getZ();
		
		double xDist = Math.abs(_x - x);
		double yDist = Math.abs(_y - y);
		double zDist = Math.abs(_z - z);
		
		double xyDist = Math.sqrt(Math.pow(xDist, 2.0) * Math.pow(yDist, 2.0));
		double xyzDist = Math.sqrt(Math.pow(xyDist, 2.0) * Math.pow(zDist, 2.0));
		
		return xyzDist;	 
	}

	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getZ() {
		return z;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public void setZ(double z) {
		this.z = z;
	}
	
	public boolean isEqual(Coordinate coordinate) {
		if (coordinate == null)
			return false;
		Coordinate other = coordinate;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.getX()))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.getY()))
			return false;
		if (Double.doubleToLongBits(z) != Double.doubleToLongBits(other.getZ()))
			return false;
		return true;
	}
	
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		return isEqual((Coordinate)obj);
	}

	@Override
	public String toString() {
		return "Coordinate [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
	
}
