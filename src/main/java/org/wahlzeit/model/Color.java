/**
 * 
 */
package org.wahlzeit.model;

import org.wahlzeit.utils.EnumValue;

/**
 * @author Karim Awad
 *
 */
public enum Color implements EnumValue {

	/**
	 * More Colors to be added eventually
	 */
	BLACK(0), WHITE(1), YELLOW(2), BROWN(3), RED(4);

	/**
	 *
	 */
	private static Color[] allValues = {
			BLACK, WHITE, YELLOW, BROWN, RED
	};

	/**
	 * @methodtype conversion
	 */
	public static Color getFromInt(int myValue) throws IllegalArgumentException {
		assertIsValidColorAsInt(myValue);
		return allValues[myValue];
	}

	/**
	 *
	 */
	protected static void assertIsValidColorAsInt(int myValue) throws IllegalArgumentException {
		if ((myValue < 0) || (myValue > 4)) {
			throw new IllegalArgumentException("invalid Color int: " + myValue);
		}
	}

	/**
	 *
	 */
	private static final String[] valueNames = {
			"Black", "White", "Yellow", "Brown", "Red"
	};

	/**
	 * @methodtype conversion
	 */
	public static Color getFromString(String myColor) throws IllegalArgumentException {
		for (Color color : Color.values()) {
			if (valueNames[color.asInt()].equals(myColor)) {
				return color;
			}
		}

		throw new IllegalArgumentException("invalid Gender string: " + myColor);
	}

	/**
	 *
	 */
	private int value;

	/**
	 *
	 */
	Color(int myValue) {
		value = myValue;
	}

	/**
	 *
	 */
	public int asInt() {
		return value;
	}

	/**
	 *
	 */
	public String asString() {
		return valueNames[value];
	}

	/**
	 *
	 */
	public Color[] getAllValues() {
		return allValues;
	}

	/**
	 *
	 */
	public String getTypeName() {
		return "Color";
	}

}
