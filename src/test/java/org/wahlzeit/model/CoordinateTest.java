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
import org.wahlzeit.utils.exceptions.IllegalCoordinateException;


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
	public void setUp() throws IllegalCoordinateException {
		cartesian = CartesianCoordinate.getCartesianCoordinate(33.0, 52.0, 120.0);
		cartesian1 = CartesianCoordinate.getCartesianCoordinate(33.0, 52.0, 120.0);
		cartesian2 = CartesianCoordinate.getCartesianCoordinate(33.0, 52.0, 99.0);
		cartesian3 = CartesianCoordinate.getCartesianCoordinate(33.0, 90.0, 120.0);
		cartesian4 = CartesianCoordinate.getCartesianCoordinate(5.0, 52.0, 120.0);
		cartesian5 = CartesianCoordinate.getCartesianCoordinate(0.0, 0.0, 0.0);
		cartesian6 = CartesianCoordinate.getCartesianCoordinate(1.0, 0.0, 2.0);
		cartesian7 = CartesianCoordinate.getCartesianCoordinate(-1.0, 2.0, 0.0);
		cartesian8 = CartesianCoordinate.getCartesianCoordinate(0.0, 2.0, 1.0);
		cartesian9 = CartesianCoordinate.getCartesianCoordinate(1.0, 2.0, -2.0);
		
		spheric = SphericCoordinate.getSphericCoordinate(33.0, 52.0, 120.0);
		spheric1 = SphericCoordinate.getSphericCoordinate(33.0, 52.0, 120.0);
		spheric2 = SphericCoordinate.getSphericCoordinate(33, 52.0, 0);
		
		//Berlin
		earth1 = SphericCoordinate.getSphericCoordinate(52.517, 13.40, 6370);
		//Tokio
		earth2 = SphericCoordinate.getSphericCoordinate(35.70, 139.767, 6370);
	}
	
	@Test
	public void testConversion() throws IllegalCoordinateException {
		SphericCoordinate cartToSpher = cartesian.asSphericCoordinate();
		assertTrue(cartToSpher.isEqual(cartesian));
		
		CartesianCoordinate spherToCart = spheric.asCartesianCoordinate();
		assertTrue(spherToCart.isEqual(spheric));
		
		
	}
	
	@Test()
	public void testClassInvariants() throws IllegalCoordinateException {
		Coordinate test;
		try{
			test = SphericCoordinate.getSphericCoordinate(0, 0, -1);
			fail();}
		catch(IllegalCoordinateException e) {};
		
		try{
			test = SphericCoordinate.getSphericCoordinate(0, -1, 0);
			fail();}
		catch(IllegalCoordinateException e) {};
		
		try{
			test = SphericCoordinate.getSphericCoordinate(0, -1, 0);
			fail();}
		catch(IllegalCoordinateException e) {};
		
		try{
			test = SphericCoordinate.getSphericCoordinate(-1, 0, 0);
			fail();}
		catch(IllegalCoordinateException e) {};
		
		try{
			test = SphericCoordinate.getSphericCoordinate(0, 0, Double.NaN);
			fail();}
		catch(IllegalCoordinateException e) {};
		
		try{
			test = SphericCoordinate.getSphericCoordinate(0, Double.NEGATIVE_INFINITY, 0);
			fail();}
		catch(IllegalCoordinateException e) {};
		
	}
	
	@Test
	public void testGetDistance() throws IllegalCoordinateException {
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

	@SuppressWarnings("unlikely-arg-type")
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
	
	@Test
	public void testSharedCoordinates() {
		assertTrue(cartesian == cartesian1);
		assertTrue(spheric == spheric1);
	}

}
