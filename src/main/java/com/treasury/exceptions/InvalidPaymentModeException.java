package com.treasury.exceptions;

public class InvalidPaymentModeException extends Exception {

	private static final long serialVersionUID = 5587630149065438921L;

	public InvalidPaymentModeException() {
	}

	public InvalidPaymentModeException(String message) {
		super(message);
	}

	public InvalidPaymentModeException(Throwable cause) {
		super(cause);
	}

	public InvalidPaymentModeException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidPaymentModeException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
