/**
 * 
 */
package org.wahlzeit.utils.exceptions;

public class IllegalOwlException extends Exception {

	/**
	 * 
	 */
	public IllegalOwlException() {
	}

	/**
	 * @param message
	 */
	public IllegalOwlException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public IllegalOwlException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public IllegalOwlException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public IllegalOwlException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
