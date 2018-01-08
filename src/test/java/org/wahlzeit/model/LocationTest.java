/*
* LocationTest
*
* Version: 1.0
*
* Date: 29.10.17
*
*/
package org.wahlzeit.model;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;
import org.wahlzeit.utils.exceptions.IllegalCoordinateException;

public class LocationTest {
	
	private Location test;
	private Location test1;
	private Location test2;
	private Location test3;
	private Location test4;

	@Before
	public void setUp() throws IllegalCoordinateException {
		test = new Location(CartesianCoordinate.getCartesianCoordinate(1.0, 2.0, 10.0));
		test1 = new Location(CartesianCoordinate.getCartesianCoordinate(1.0, 2.0, 10.0));
		test2 = new Location(CartesianCoordinate.getCartesianCoordinate(1.0, 2.0, 9.0));
		test3 = new Location(CartesianCoordinate.getCartesianCoordinate(1.0, 3.0, 10.0));
		test4 = new Location(CartesianCoordinate.getCartesianCoordinate(2.0, 2.0, 10.0));
	}
	
	@Test
	public void testEqualsObject() throws IllegalCoordinateException {
		assertTrue(test.equals(test1));
		assertFalse(test.equals(test2));
		assertFalse(test.equals(test3));
		assertFalse(test.equals(test4));
		
		//test corner cases
		assertFalse(test.equals(new Location()));
		assertFalse(test.equals(null));
		assertFalse(test.equals(CartesianCoordinate.getCartesianCoordinate(1.0,2.0,3.0)));
		assertTrue(test.equals(test));
	}

}

