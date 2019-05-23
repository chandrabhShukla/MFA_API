package com.tgt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Chandra Bhan
 * 
 */
@Slf4j
@SpringBootApplication
public class TGTApplication {

	public static void main(String[] args) {
		SpringApplication.run(TGTApplication.class, args);
		log.info("TGT application started ");
	}

}
