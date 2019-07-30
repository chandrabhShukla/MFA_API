package com.tgt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Chandra Bhan
 * 
 */
//first name lastname and email
//phone number optional
// gateway api like---metrics collection services put data in mongo db,
// gateway api
// mongo db mlab
//503 small power
// git hub repository
//suffix your project with MFA api
@Slf4j
@SpringBootApplication
public class TGTApplication {

	public static void main(String[] args) {
		SpringApplication.run(TGTApplication.class, args);
	
	}

}
