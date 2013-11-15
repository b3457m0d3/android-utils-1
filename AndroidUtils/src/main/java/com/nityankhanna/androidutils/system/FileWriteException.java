package com.nityankhanna.androidutils.system;

/**
 * Created by Nityan Khanna on 14/11/13.
 * Copyright (c) 2013 NAATec. All rights reserved.
 */

/**
 * Represents an exception that occurs when writing to a file.
 */
public class FileWriteException extends RuntimeException {

	/**
	 * Initializes a new instance of the FileWriteException.
	 */
	public FileWriteException() {
	}

	/**
	 * Initializes a new instance of the FileWriteException with a specified message.
	 *
	 * @param detailMessage The message of the exception.
	 */
	public FileWriteException(String detailMessage) {
		super(detailMessage);
	}
}