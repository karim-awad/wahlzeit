/*
 * Copyright (c) 
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package org.wahlzeit.model;

import java.io.Serializable;
import java.util.Random;

/**
 * An owlid identifies an owl with a unique number.
 * The number has an equivalent string for web access. 
 * This class also hands out the ids.
 */
public class OwlId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5841029839798326599L;

	/**
	 * 0 is never returned from nextValue; first value is 1
	 */
	protected static int currentId = 0;

	/**
	 *
	 */
	public static final int BUFFER_SIZE_INCREMENT = 64;

	/**
	 *
	 */
	public static final OwlId NULL_ID = new OwlId(0);

	/**
	 *
	 */
	protected static OwlId[] ids = new OwlId[BUFFER_SIZE_INCREMENT];

	/**
	 * What a hack :-)
	 */
	public static final int ID_START = getFromString("x1abz") + 1;

	/**
	 *
	 */
	protected static Random randomNumber = new Random(System.currentTimeMillis());

	private OwlId() {
		// do nothing, necessary for Objectify to load PhotoIds
	}

	/**
	 *
	 */
	public static int getCurrentIdAsInt() {
		return currentId;
	}

	/**
	 *
	 */
	public static synchronized void setCurrentIdFromInt(int id) {
		currentId = id;
		ids = new OwlId[currentId + BUFFER_SIZE_INCREMENT];
		ids[0] = NULL_ID;
	}

	/**
	 *
	 */
	public static synchronized int getNextIdAsInt() {
		currentId += 1;
		if (currentId >= ids.length) {
			OwlId[] nids = new OwlId[currentId + BUFFER_SIZE_INCREMENT];
			System.arraycopy(ids, 0, nids, 0, currentId);
			ids = nids;
		}
		return currentId;
	}

	/**
	 *
	 */
	public static OwlId getIdFromInt(int id) {
		if ((id < 0) || (id > currentId)) {
			return NULL_ID;
		}

		// @FIXME http://en.wikipedia.org/wiki/Double-checked_locking
		OwlId result = ids[id];
		if (result == null) {
			synchronized (ids) {
				result = ids[id];
				if (result == null) {
					result = new OwlId(id);
					ids[id] = result;
				}
			}
		}

		return result;
	}

	/**
	 *
	 */
	public static OwlId getIdFromString(String id) {
		return getIdFromInt(getFromString(id));
	}

	/**
	 *
	 */
	public static OwlId getNextId() {
		return getIdFromInt(getNextIdAsInt());
	}

	/**
	 *
	 */
	public static OwlId getRandomId() {
		int max = getCurrentIdAsInt() - 1;
		int id = randomNumber.nextInt();
		id = (id == Integer.MIN_VALUE) ? id++ : id;
		id = (Math.abs(id) % max) + 1;
		return getIdFromInt(id);
	}

	/**
	 *
	 */
	protected int value = 0;
	protected String stringValue = null;

	/**
	 *
	 */
	protected OwlId(int myValue) {
		value = myValue;
		stringValue = getFromInt(myValue);
	}

	/**
	 *
	 */
	public boolean equals(Object o) {
		// @FIXME

		if (!(o instanceof OwlId)) {
			return false;
		}

		OwlId pid = (OwlId) o;
		return isEqual(pid);
	}

	/**
	 *
	 */
	public boolean isEqual(OwlId other) {
		return other.value == value;
	}

	/**
	 * @methodtype get
	 */
	public int hashCode() {
		return value;
	}

	/**
	 *
	 */
	public boolean isNullId() {
		return this == NULL_ID;
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
		return stringValue;
	}

	/**
	 *
	 */
	public static String getFromInt(int id) {
		StringBuffer result = new StringBuffer(10);

		id += ID_START;
		for (; id > 0; id = id / 36) {
			char letterOrDigit;
			int modulus = id % 36;
			if (modulus < 10) {
				letterOrDigit = (char) ((int) '0' + modulus);
			} else {
				letterOrDigit = (char) ((int) 'a' - 10 + modulus);
			}
			result.insert(0, letterOrDigit);

		}

		return "x" + result.toString();
	}

	/**
	 *
	 */
	public static int getFromString(String value) {
		int result = 0;
		for (int i = 1; i < value.length(); i++) {
			int temp = 0;
			char letterOrDigit = value.charAt(i);
			if (letterOrDigit < 'a') {
				temp = (int) letterOrDigit - '0';
			} else {
				temp = 10 + (int) letterOrDigit - 'a';
			}
			result = result * 36 + temp;
		}

		result -= ID_START;
		if (result < 0) {
			result = 0;
		}

		return result;
	}

}
