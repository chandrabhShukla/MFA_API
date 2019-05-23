package com.tgt.exception;

import java.util.List;

public class InvalidInputException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidInputException(List<String> errorKeyList) {

		this(String.join(",", errorKeyList));

	}

	public InvalidInputException(String errorKeys) {

		super(errorKeys);
	}

}
