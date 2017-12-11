/**
 * 
 */
package org.wahlzeit.utils.exceptions;


public class IllegalCoordinateException extends Exception {

	/**
	 * 
	 */
	public IllegalCoordinateException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public IllegalCoordinateException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public IllegalCoordinateException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public IllegalCoordinateException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public IllegalCoordinateException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
