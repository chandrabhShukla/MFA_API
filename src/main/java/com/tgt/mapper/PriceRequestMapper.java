package com.tgt.mapper;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.tgt.domain.Price;
import com.tgt.dto.PriceRequestDTO;

@Component
public class PriceRequestMapper {

	public PriceRequestDTO mapPriceRequestDomainToDTO(Price price) {

		if (Optional.ofNullable(price).isPresent()) {
			PriceRequestDTO priceRequestDTO = new PriceRequestDTO();
			priceRequestDTO.setCurrencyCode(price.getCurrencyCode());
			priceRequestDTO.setPriceValue(price.getPriceValue());
			return priceRequestDTO;
		}
		return null;
	}

	public Price mapPriceRequestDTOToDomain(PriceRequestDTO priceRequestDTO) {
		if (Optional.ofNullable(priceRequestDTO).isPresent()) {
			Price price = new Price(priceRequestDTO.getPriceValue(), priceRequestDTO.getCurrencyCode());
			return price;
		}
		return null;
	}
}
