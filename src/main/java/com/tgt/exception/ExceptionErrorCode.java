package com.tgt.exception;


public enum ExceptionErrorCode {
    GENERIC_ERROR(1000, "Generic Error"),
    API_CALL_ERROR(1001, "API call Error"),
    MAPPING_ERROR(1002, "Mapping Error"),
    DUPLICATE_DATA_PERSIST_ERROR(1003, "Duplicate_Data_Persist Error"),
    DATA_NOT_FOUND(1004, "Data Not Found");
    
	private final int errorCode;

	private final String errorMessage;

	ExceptionErrorCode(final int errorCode, final String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}
