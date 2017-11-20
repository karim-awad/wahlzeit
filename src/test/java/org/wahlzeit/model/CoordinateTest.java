/*
* CoordinateTest
*
* Version: 1.0
*
* Date: 29.10.17
*
*/
package org.wahlzeit.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CoordinateTest {
	
	private CartesianCoordinate cartesian;
	private CartesianCoordinate cartesian1;
	private CartesianCoordinate cartesian2;
	private CartesianCoordinate cartesian3;
	private CartesianCoordinate cartesian4;
	private CartesianCoordinate cartesian5;
	private CartesianCoordinate cartesian6;
	private CartesianCoordinate cartesian7;
	private CartesianCoordinate cartesian8;
	private CartesianCoordinate cartesian9;
	
	private SphericCoordinate spheric;
	private SphericCoordinate spheric1;
	private SphericCoordinate spheric2;

	@BeforeEach
	public void setUp() {
		cartesian = new CartesianCoordinate(33.0, 52.0, 120.0);
		cartesian1 = new CartesianCoordinate(33.0, 52.0, 120.0);
		cartesian2 = new CartesianCoordinate(33.0, 52.0, 99.0);
		cartesian3 = new CartesianCoordinate(33.0, 90.0, 120.0);
		cartesian4 = new CartesianCoordinate(5.0, 52.0, 120.0);
		cartesian5 = new CartesianCoordinate(0.0, 0.0, 0.0);
		cartesian6 = new CartesianCoordinate(1.0, 0.0, 2.0);
		cartesian7 = new CartesianCoordinate(-1.0, 2.0, 0.0);
		cartesian8 = new CartesianCoordinate(0.0, 2.0, 1.0);
		cartesian9 = new CartesianCoordinate(1.0, 2.0, -2.0);
		
		spheric = new SphericCoordinate(33.0, 52.0, 120.0);
		spheric1 = new SphericCoordinate(33.0, 52.0, 120.0);
		spheric2 = new SphericCoordinate(33, 52.0, 0);
	}
	
	@Test
	void testConversion() {
		SphericCoordinate cartToSpher = cartesian.asSphericCoordinate();
		assertTrue(cartToSpher.isEqual(cartesian));
		
		CartesianCoordinate spherToCart = spheric.asCartesianCoordinate();
		assertTrue(spherToCart.isEqual(spheric));
		
		
	}
	
	@Test
	void testGetDistance() {
		//same coordinates
		assertEquals(0.0, cartesian.getDistance(cartesian1),1e-7);
		assertEquals(0.0, spheric.getDistance(spheric1),1e-7);
		assertEquals(0.0, spheric2.getDistance(cartesian5), 1e-7);
		
		//only differences on one axis
		assertEquals(21.0, cartesian.getDistance(cartesian2),1e-7);
		assertEquals(38.0, cartesian.getDistance(cartesian3),1e-7);
		assertEquals(28.0, cartesian.getDistance(cartesian4),1e-7);
		
		//differences on two axes
		assertEquals(Math.sqrt(5.0), cartesian5.getDistance(cartesian6),1e-7);
		assertEquals(Math.sqrt(5.0), cartesian5.getDistance(cartesian7),1e-7);
		assertEquals(Math.sqrt(5.0), cartesian5.getDistance(cartesian8),1e-7);
		
		//differences on all axes
		assertEquals(3.0, cartesian5.getDistance(cartesian9),1e-7);
	}

	@Test
	void testEqualsObject() { //also implicitly tests isEqual()
		
		assertTrue(cartesian.equals(cartesian1));
		assertTrue(spheric.equals(spheric1));
		assertFalse(cartesian.equals(cartesian2));
		assertFalse(cartesian.equals(cartesian3));
		assertFalse(cartesian.equals(cartesian4));
		
		//test corner cases
		assertFalse(cartesian.equals(null));
		assertFalse(cartesian.equals(new Location()));
		assertTrue(cartesian.equals(cartesian));
	}

}
