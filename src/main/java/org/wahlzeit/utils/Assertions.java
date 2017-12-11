/**
 * 
 */
package org.wahlzeit.utils;

import com.google.appengine.api.memcache.InvalidValueException;

public class Assertions {

	/**
	 * @methodtype Assertion
	 */
	public static void assertNotNull(Object obj, String message) {
		if(obj == null) {
			throw new InvalidValueException(message);
		}
	}
	
	/**
	 * @methodtype Assertion
	 */
	public static void assertValidString(String str, String message) {
		if(str == null) {
			throw new InvalidValueException(message);
		}
	}
	
	/**
	 * @methodtype Assertion
	 */
	public static void assertValidDouble(Double doubleVal, String message){
		if(doubleVal.isInfinite() || doubleVal.isNaN()) {
			throw new InvalidValueException(message);
		}
	}
	
	/**
	 * @methodtype Assertion
	 */
	public static void assertPositive(int val, String message) {
		if(val<0) {
			throw new InvalidValueException(message);
		}
	}
	
	/**
	 * @methodtype Assertion
	 */
	public static void assertPositive(double val, String message) {
		if(val<0) {
			throw new InvalidValueException(message);
		}
	}
	
	/**
	 * @methodtype Assertion
	 */
	public static void assertValidDistance(Double distance, String message){
		assertValidDouble(distance, message);
		if(distance < 0) {
			throw new InvalidValueException(message);
		}	
	}

}
