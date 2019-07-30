package com.tgt.exception;

/**
 * @author Chandra Bhan
 * 
 */
public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String errorMessage;
	private int errorCode;

	public UserNotFoundException(String errorMessage, int errorCode) {
		super(errorMessage);
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}

	public UserNotFoundException(ExceptionErrorCode exceptionErrorCode) {
		super(exceptionErrorCode.getErrorMessage());
		this.errorMessage = exceptionErrorCode.getErrorMessage();
		this.errorCode = exceptionErrorCode.getErrorCode();
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

}