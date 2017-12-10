/*
* CoordinateTest
*
* Version: 1.0
*
* Date: 29.10.17
*
*/
package org.wahlzeit.model;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;


public class CoordinateTest {
	
	/**
	 * 
	 */
	private static final double EPSILON = 1e-7;
	
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
	
	private SphericCoordinate earth1;
	private SphericCoordinate earth2;
	
	@Before
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
		
		//Berlin
		earth1 = new SphericCoordinate(52.517, 13.40, 6370);
		//Tokio
		earth2 = new SphericCoordinate(35.70, 139.767, 6370);
	}
	
	@Test
	public void testConversion() {
		SphericCoordinate cartToSpher = cartesian.asSphericCoordinate();
		assertTrue(cartToSpher.isEqual(cartesian));
		
		CartesianCoordinate spherToCart = spheric.asCartesianCoordinate();
		assertTrue(spherToCart.isEqual(spheric));
		
		
	}
	
	@Test()
	public void testClassInvariants() {
		Coordinate test;
		try{
			test = new SphericCoordinate(0, 0, -1);
			fail();}
		catch(IllegalStateException e) {};
		
		try{
			test = new SphericCoordinate(0, -1, 0);
			fail();}
		catch(IllegalStateException e) {};
		
		try{
			test = new SphericCoordinate(0, -1, 0);
			fail();}
		catch(IllegalStateException e) {};
		
		try{
			test = new SphericCoordinate(-1, 0, 0);
			fail();}
		catch(IllegalStateException e) {};
		
		try{
			test = new CartesianCoordinate(0, 0, Double.NaN);
			fail();}
		catch(IllegalStateException e) {};
		
		try{
			test = new CartesianCoordinate(0, Double.NEGATIVE_INFINITY, 0);
			fail();}
		catch(IllegalStateException e) {};
		
		CartesianCoordinate test1 = new CartesianCoordinate(0, 0, -1);
		try{
			test1.setX(Double.NaN);
			fail();
			}
		catch(IllegalStateException e) {};
		
		try{
			test1.setX(Double.NEGATIVE_INFINITY);
			fail();
			}
		catch(IllegalStateException e) {};
		
		SphericCoordinate test2 = new SphericCoordinate();
		
		try{
			test2.setRadius(-1);
			fail();
			}
		catch(IllegalStateException e) {};
		
		try{
			test2.setLatitude(Double.NaN);
			fail();
			}
		catch(IllegalStateException e) {};
		
	}
	
	@Test
	public void testGetDistance() {
		//same coordinates
		assertEquals(0.0, cartesian.getDistance(cartesian1),EPSILON);
		assertEquals(0.0, spheric.getDistance(spheric1),EPSILON);
		assertEquals(0.0, spheric2.getDistance(cartesian5), EPSILON);
		
		
		//only differences on one axis
		assertEquals(21.0, cartesian.getDistance(cartesian2),EPSILON);
		assertEquals(38.0, cartesian.getDistance(cartesian3),EPSILON);
		assertEquals(28.0, cartesian.getDistance(cartesian4),EPSILON);
		
		//differences on two axes
		assertEquals(Math.sqrt(5.0), cartesian5.getDistance(cartesian6),EPSILON);
		assertEquals(Math.sqrt(5.0), cartesian5.getDistance(cartesian7),EPSILON);
		assertEquals(Math.sqrt(5.0), cartesian5.getDistance(cartesian8),EPSILON);
		
		//differences on all axes
		assertEquals(3.0, cartesian5.getDistance(cartesian9),EPSILON);
		
		//sphericDistances
		assertEquals(8918.0, earth1.getSphericDistance(earth2), 1);
		
		
	}

	@Test
	public void testEqualsObject() { //also implicitly tests isEqual()
		
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
