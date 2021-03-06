package com.tgt.validator;

import static com.tgt.util.Constants.STATUS_NOT_OK;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import com.tgt.exception.InvalidInputException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ValidationErrorParser {

	private static final Map<String, String> ERROR_CODES_MAP = Collections
			.unmodifiableMap(new HashMap<String, String>() {
				{
					put("INCORRECT_USER_REQUEST", "_ERR_USER_REQUEST_REQUIRED");
					
				}
			});

	public static void processErrors(BindingResult errors) {
		if (null != errors) {
			List<String> errorCodes = new ArrayList<String>();
			for (FieldError error : errors.getFieldErrors()) {
				String errorKey = error.getCodes()[1];
				errorCodes.add(ERROR_CODES_MAP.get(errorKey));
			
			}

			for (ObjectError error : errors.getGlobalErrors()) {
				String errorKey = error.getCodes()[1];
				errorCodes.add(ERROR_CODES_MAP.get(errorKey));
			}
			if (errorCodes.size() > 0) {
				throw new InvalidInputException(errorCodes);
			}
		}
	}
}