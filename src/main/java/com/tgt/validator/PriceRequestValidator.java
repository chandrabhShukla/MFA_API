package com.tgt.validator;

import java.util.Objects;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.tgt.dto.PriceRequestDTO;

public class PriceRequestValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return PriceRequestDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		PriceRequestDTO priceRequestDTO = (PriceRequestDTO) target;
		if (Objects.nonNull(priceRequestDTO.getPriceValue())) {
			if (Objects.isNull(priceRequestDTO.getPriceValue())
					|| StringUtils.isEmpty(priceRequestDTO.getCurrencyCode()))
				errors.reject("INCORRECT_PRICE_DETAILS");
		}
	}

}
