package org.wahlzeit.exception;

/**
 * 
 * @author Yao Guo
 * @collaboration location
 */
public class LocationException extends Exception {

	private static final long serialVersionUID = 483779968809308468L;

	public LocationException() {
		super();
	}
	
	public LocationException(String message) {
		super(message);
	}
	
	public LocationException(Throwable error) {
		super(error);
	}
	
	public LocationException(String message, Throwable error) {
		super(message, error);
	}
}