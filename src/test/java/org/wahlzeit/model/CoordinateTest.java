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
	
	private Coordinate test;
	private Coordinate test1;
	private Coordinate test2;
	private Coordinate test3;
	private Coordinate test4;
	private Coordinate test5;
	private Coordinate test6;
	private Coordinate test7;
	private Coordinate test8;
	private Coordinate test9;

	@BeforeEach
	public void setUp() {
		test = new Coordinate(33.0, 52.0, 120.0);
		test1 = new Coordinate(33.0, 52.0, 120.0);
		test2 = new Coordinate(33.0, 52.0, 99.0);
		test3 = new Coordinate(33.0, 90.0, 120.0);
		test4 = new Coordinate(5.0, 52.0, 120.0);
		test5 = new Coordinate(0.0, 0.0, 0.0);
		test6 = new Coordinate(1.0, 0.0, 2.0);
		test7 = new Coordinate(-1.0, 2.0, 0.0);
		test8 = new Coordinate(0.0, 2.0, 1.0);
		test9 = new Coordinate(1.0, 2.0, -2.0);
	}
	
	@Test
	void testGetDistance() {
		//same coordinates
		assertEquals(0.0, test.getDistance(test1),1e-7);
		
		//only differences on one axis
		assertEquals(21.0, test.getDistance(test2),1e-7);
		assertEquals(38.0, test.getDistance(test3),1e-7);
		assertEquals(28.0, test.getDistance(test4),1e-7);
		
		//differences on two axes
		assertEquals(Math.sqrt(5.0), test5.getDistance(test6),1e-7);
		assertEquals(Math.sqrt(5.0), test5.getDistance(test7),1e-7);
		assertEquals(Math.sqrt(5.0), test5.getDistance(test8),1e-7);
		
		//differences on all axes
		assertEquals(3.0, test5.getDistance(test9),1e-7);
	}

	@Test
	void testEqualsObject() { //also implicitly tests isEqual()
		
		assertTrue(test.equals(test1));
		assertFalse(test.equals(test2));
		assertFalse(test.equals(test3));
		assertFalse(test.equals(test4));
		
		//test corner cases
		assertFalse(test.equals(null));
		assertFalse(test.equals(new Location()));
		assertTrue(test.equals(test));
	}

}
