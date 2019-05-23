package com.tgt.validator;

import java.util.Objects;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.tgt.dto.ProductRequestDTO;

public class ProductRequestValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {

		return ProductRequestDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ProductRequestDTO productRequestDTO = (ProductRequestDTO) target;
		if (Objects.isNull(productRequestDTO) || StringUtils.isEmpty(productRequestDTO.getId())
				|| StringUtils.isEmpty(productRequestDTO.getName()))
			errors.reject("INCORRECT_PRODUCT_REQUEST");

		if (Objects.nonNull(productRequestDTO.getPrice())) {
			if (Objects.isNull(productRequestDTO.getPrice().getPriceValue())
					|| StringUtils.isEmpty(productRequestDTO.getPrice().getCurrencyCode()))
				errors.reject("INCORRECT_PRICE_DETAILS");
		}

	}

}
