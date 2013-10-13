package com.nityankhanna.androidutils;

/**
 * Created by Nityan Khanna on 29/06/13.
 */

/**
 * An exception which is thrown when an unexpected value is input.
 */
public class InvalidArgumentException extends RuntimeException {

	/**
	 * The message for the exception.
	 */
	private String message;

	/**
	 * Initializes a new InvalidArgumentException with a null message.
	 */
	public InvalidArgumentException() {
		super();
	}

	/**
	 * Initializes a new InvalidArgumentException with a specified message.
	 *
	 * @param message The message for the exception.
	 */
	public InvalidArgumentException(String message) {
		super(message);
		this.message = message;
	}
}