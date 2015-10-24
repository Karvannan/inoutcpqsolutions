package com.inoutcorp.cpq.opportunity.utils;

/**
 * The Class InOutException.
 */
public class InOutException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The message. */
	private String message;

	/** The error code. */
	private InOutErrorCodes errorCode;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Throwable#getMessage()
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message
	 *            the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Gets the error code.
	 *
	 * @return the error code
	 */
	public InOutErrorCodes getErrorCode() {
		return errorCode;
	}

	/**
	 * Sets the error code.
	 *
	 * @param errorCode
	 *            the new error code
	 */
	public void setErrorCode(InOutErrorCodes errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * Instantiates a new in out exception.
	 *
	 * @param errorCode
	 *            the error code
	 * @param message
	 *            the message
	 */
	public InOutException(InOutErrorCodes errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
		this.message = message;
	}

}
