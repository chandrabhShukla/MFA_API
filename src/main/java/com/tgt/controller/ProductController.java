package com.tgt.controller;

import static com.tgt.util.Constants.LOGGER_KO_PATTERN;
import static com.tgt.util.Constants.LOGGER_OK_PATTERN;
import static com.tgt.validator.ValidationErrorParser.processErrors;

import java.text.MessageFormat;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Stopwatch;
import com.tgt.domain.Price;
import com.tgt.domain.Product;
import com.tgt.dto.PriceRequestDTO;
import com.tgt.dto.ProductRequestDTO;
import com.tgt.exception.ExceptionErrorCode;
import com.tgt.exception.ProductNotFoundException;
import com.tgt.mapper.PriceRequestMapper;
import com.tgt.mapper.ProductRequestMapper;
import com.tgt.service.ProductService;
import com.tgt.util.JsonUtil;
import com.tgt.validator.PriceRequestValidator;
import com.tgt.validator.ProductRequestValidator;

import lombok.extern.slf4j.Slf4j;

/**
 * Api to fetch, update and create new product
 * 
 * @author Chandra Bhan
 */

@Slf4j
@Validated
@RestController
@Configuration
@RequestMapping("/product")
public class ProductController {

	public static final String LOG_OP_INFO = "PRODUCT_CONTROLLER";

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductRequestMapper productRequestMapper;

	@Autowired
	private PriceRequestMapper priceRequestMapper;

	@InitBinder("priceRequestDTO")
	protected void initBinderForPrice(WebDataBinder binder) {
		binder.addValidators(new PriceRequestValidator());
	}

	@InitBinder("productRequestDTO")
	protected void initBinderForProduct(WebDataBinder binder) {
		binder.addValidators(new ProductRequestValidator());
	}

	/**
	 * @param id
	 * @return Product details of respective product_id
	 */
	@RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> getProductDetails(@NotNull @PathVariable String id) {
		final Stopwatch stopwatch = Stopwatch.createUnstarted().start();
		log.info(LOGGER_OK_PATTERN, LOG_OP_INFO,
				MessageFormat.format("Get product service invkoed with product id : {0}", id));

		Product product = productService.getProduct(id);

		if (product == null) {
			log.error(LOGGER_KO_PATTERN, LOG_OP_INFO,
					MessageFormat.format("product id : {0} does not exist in the record", id));
			throw new ProductNotFoundException(ExceptionErrorCode.DATA_NOT_FOUND);
		}

		ProductRequestDTO productRequestDTO = productRequestMapper.mapProductRequestDomainToDTO(product);

		log.info(LOGGER_OK_PATTERN, LOG_OP_INFO, MessageFormat.format(
				"Get product service invkoed successfully with product id : {0} and completed within {1} milliseconds",
				id, stopwatch.stop().elapsed(TimeUnit.MILLISECONDS)));
		return new ResponseEntity<>(productRequestDTO, HttpStatus.OK);
	}

	/**
	 * @param productRequestDTO
	 * @return Create a new product
	 * @see ProductRequestDTO
	 */
	@RequestMapping(path = "/", method = RequestMethod.POST)
	public ResponseEntity<?> createProduct(@NotNull @RequestBody @Valid ProductRequestDTO productRequestDTO,
			BindingResult bindingResult) {
		final Stopwatch stopwatch = Stopwatch.createUnstarted().start();
		log.info(LOGGER_OK_PATTERN, LOG_OP_INFO, MessageFormat
				.format("Create product service invkoed with payload : {0}", JsonUtil.toJson(productRequestDTO)));
		processErrors(bindingResult);
		Product product = productRequestMapper.mapProductRequestDTOToDomain(productRequestDTO);

		if (productService.getProduct(product.getId()) != null) {
			log.error(LOGGER_KO_PATTERN, LOG_OP_INFO,
					MessageFormat.format("Product id : {0} ,is already exist in the record", product.getId()));
			throw new ProductNotFoundException(ExceptionErrorCode.DUPLICATE_DATA_PERSIST_ERROR);
		}

		productService.add(product);
		log.info(LOGGER_OK_PATTERN, LOG_OP_INFO, MessageFormat.format(
				"Create product service invoked succesfully with product id {0} and completed within {1} milliseconds",
				product.getId(), stopwatch.stop().elapsed(TimeUnit.MILLISECONDS)));

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	/**
	 * @param productRequestDTO
	 * @param id  product id
	 * @return Update the product price
	 * @see ProductRequestDTO
	 */
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateProductPrice(@NotNull @RequestBody @Valid PriceRequestDTO priceRequestDTO,
			@NotNull @PathVariable String id, BindingResult bindingResult) {
		final Stopwatch stopwatch = Stopwatch.createUnstarted().start();
		log.info(LOGGER_OK_PATTERN, LOG_OP_INFO, MessageFormat
				.format("Update product price service invkoed with payload : {0}", JsonUtil.toJson(priceRequestDTO)));

		processErrors(bindingResult);
		Price price = priceRequestMapper.mapPriceRequestDTOToDomain(priceRequestDTO);

		if (null == productService.getProduct(id)) {
			log.error(LOGGER_KO_PATTERN, LOG_OP_INFO,
					MessageFormat.format("product id : {0} does not exist in the record", id));
			throw new ProductNotFoundException(ExceptionErrorCode.DATA_NOT_FOUND);
		}
		productService.updateData(id, price);

		log.info(LOGGER_OK_PATTERN, LOG_OP_INFO, MessageFormat.format(
				"Update product service invkoed succesfully with product id {0} and completed within milliseconds", id,
				stopwatch.stop().elapsed(TimeUnit.MILLISECONDS)));

		return new ResponseEntity<>("Price is updated successsfully with product id:"+id,HttpStatus.OK);
	}
}
