/**
 * 
 */
package org.wahlzeit.utils.exceptions;

public class IllegalSpeciesException extends Exception {

	/**
	 * 
	 */
	public IllegalSpeciesException() {
		super();
	}

	/**
	 * @param message
	 */
	public IllegalSpeciesException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public IllegalSpeciesException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public IllegalSpeciesException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public IllegalSpeciesException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
