package com.tgt.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tgt.domain.Product;
import com.tgt.dto.ProductRequestDTO;

@Component
public class ProductRequestMapper {

	@Autowired
	private PriceRequestMapper priceRequestMapper;

	public ProductRequestDTO mapProductRequestDomainToDTO(Product product) {
		ProductRequestDTO productRequestDTO = new ProductRequestDTO();

		productRequestDTO.setId(product.getId());
		productRequestDTO.setName(product.getName());
		productRequestDTO.setPrice(priceRequestMapper.mapPriceRequestDomainToDTO(product.getPrice()));
		return productRequestDTO;
	}

	public Product mapProductRequestDTOToDomain(ProductRequestDTO productRequestDTO) {
		Product product = new Product();

		product.setId(productRequestDTO.getId());
		product.setName(productRequestDTO.getName());
		product.setPrice(priceRequestMapper.mapPriceRequestDTOToDomain(productRequestDTO.getPrice()));
		return product;
	}
}
