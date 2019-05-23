package com.tgt.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponentsBuilder;

import com.tgt.TGTSpringBootTest;
import com.tgt.dto.PriceRequestDTO;
import com.tgt.dto.ProductRequestDTO;

/**
 * Test cases for ProductController api
 * @author Chandra Bhan 
 */

@RunWith(SpringRunner.class)
public class ProductControllerTest extends TGTSpringBootTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getProductDetailsTest_SUCCESS() throws Exception {
		String uri = "/product/62736126";

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("/" + uri);

		ResponseEntity<?> responseEntity = restTemplate.exchange(builder.build().toUriString(), HttpMethod.GET, null,
				ProductRequestDTO.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		ProductRequestDTO productRequestDTO = (ProductRequestDTO) responseEntity.getBody();
		assertEquals("62736126", productRequestDTO.getId());
	}

	@Test
	public void getProductDetailsTest_ERROR() throws Exception {
		String uri = "/product/62736654";
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("/" + uri);

		ResponseEntity<?> responseEntity = restTemplate.exchange(builder.build().toUriString(), HttpMethod.GET, null,
				ProductRequestDTO.class);

		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());

	}

	@Test
	public void updateProductPriceTest_SUCCESS() throws Exception {

		PriceRequestDTO price = new PriceRequestDTO();

		price.setCurrencyCode("USD");
		price.setPriceValue(1100d);
		String productId = "62736126";

		String uri = "/product/" + productId;
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("/" + uri);

		HttpEntity<PriceRequestDTO> httpEntity = new HttpEntity<PriceRequestDTO>(price);
		restTemplate.put(builder.build().toUriString(), httpEntity);

		ResponseEntity<?> responseEntity = getProduct(productId);

		ProductRequestDTO productRequestDTO = (ProductRequestDTO) responseEntity.getBody();

		assertEquals(price.getPriceValue(), productRequestDTO.getPrice().getPriceValue());
		assertEquals(price.getCurrencyCode(), productRequestDTO.getPrice().getCurrencyCode());
	}

	@Test
	public void updateProductPriceTest_ERROR() throws Exception {

		PriceRequestDTO price = new PriceRequestDTO();

		price.setCurrencyCode("USD");
		price.setPriceValue(1100d);
		String productId = "6273111";

		String uri = "/product/" + productId;
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("/" + uri);

		HttpEntity<PriceRequestDTO> httpEntity = new HttpEntity<PriceRequestDTO>(price);
		restTemplate.put(builder.build().toUriString(), httpEntity);

		ResponseEntity<?> responseEntity = getProduct(productId);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
	}

	@Test
	public void createProductTest_SUCCESS() throws Exception {

		String uri = "/product/";
		ProductRequestDTO product = new ProductRequestDTO();
		product.setId("62736167");
		product.setName("MOBILE");
		PriceRequestDTO price = new PriceRequestDTO();
		price.setPriceValue(1000d);
		price.setCurrencyCode("USD");
		product.setPrice(price);

		HttpEntity<ProductRequestDTO> httpEntity = new HttpEntity<ProductRequestDTO>(product);

		ResponseEntity<?> postResponseEntity = restTemplate.postForEntity(uri, httpEntity, Object.class);

		assertEquals(HttpStatus.CREATED, postResponseEntity.getStatusCode());

		ResponseEntity<?> responseEntity = getProduct(product.getId());
		ProductRequestDTO productRequestDTO = (ProductRequestDTO) responseEntity.getBody();

		assertEquals(price.getPriceValue(), productRequestDTO.getPrice().getPriceValue());
		assertEquals(price.getCurrencyCode(), productRequestDTO.getPrice().getCurrencyCode());

	}

	@Test
	public void createProductTest_ERROR() throws Exception {

		String uri = "/product/";
		ProductRequestDTO product = new ProductRequestDTO();
		product.setId("62736126");
		product.setName("MOBILE");
		PriceRequestDTO price = new PriceRequestDTO();
		price.setPriceValue(1000d);
		price.setCurrencyCode("USD");
		product.setPrice(price);

		HttpEntity<ProductRequestDTO> httpEntity = new HttpEntity<ProductRequestDTO>(product);

		ResponseEntity<?> postResponseEntity = restTemplate.postForEntity(uri, httpEntity, Object.class);

		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, postResponseEntity.getStatusCode());

		ResponseEntity<?> responseEntity = getProduct(product.getId());
		ProductRequestDTO productRequestDTO = (ProductRequestDTO) responseEntity.getBody();
		assertNotNull(productRequestDTO);

	}

	private ResponseEntity<?> getProduct(String id) {
		final String getUri = "/product/" + id;

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("/" + getUri);

		ResponseEntity<?> responseEntity = restTemplate.exchange(builder.build().toUriString(), HttpMethod.GET, null,
				ProductRequestDTO.class);

		return responseEntity;
	}

}
