/*
* LocationTest
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

class LocationTest {
	
	private Location test;
	private Location test1;
	private Location test2;
	private Location test3;
	private Location test4;

	@BeforeEach
	public void setUp() {
		test = new Location(new Coordinate(1.0, 2.0, 10.0));
		test1 = new Location(new Coordinate(1.0, 2.0, 10.0));
		test2 = new Location(new Coordinate(1.0, 2.0, 9.0));
		test3 = new Location(new Coordinate(1.0, 3.0, 10.0));
		test4 = new Location(new Coordinate(2.0, 2.0, 10.0));
	}
	
	@Test
	public void testEqualsObject() {
		assertTrue(test.equals(test1));
		assertFalse(test.equals(test2));
		assertFalse(test.equals(test3));
		assertFalse(test.equals(test4));
		
		//test corner cases
		assertFalse(test.equals(new Location()));
		assertFalse(test.equals(null));
		assertFalse(test.equals(new Coordinate(1.0,2.0,3.0)));
		assertTrue(test.equals(test));
	}

}

