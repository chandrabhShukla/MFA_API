package com.tgt.validator;

import java.util.Objects;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.tgt.dto.UserRequestDTO;

public class UserRequestValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {

		return UserRequestDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserRequestDTO userRequestDTO = (UserRequestDTO) target;
		if (Objects.isNull(userRequestDTO) || StringUtils.isEmpty(userRequestDTO.getId())
				|| StringUtils.isEmpty(userRequestDTO.getName()))
			errors.reject("INCORRECT_USER_REQUEST");

	}

}