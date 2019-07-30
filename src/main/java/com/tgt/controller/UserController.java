package com.tgt.controller;

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

import com.tgt.domain.User;
import com.tgt.dto.UserRequestDTO;
import com.tgt.exception.ExceptionErrorCode;
import com.tgt.exception.UserNotFoundException;
import com.tgt.mapper.UserRequestMapper;
import com.tgt.service.UserService;
import com.tgt.validator.UserRequestValidator;
import static com.tgt.validator.ValidationErrorParser.processErrors;
import lombok.extern.slf4j.Slf4j;

/**
 * Api to fetch  and create new user
 * 
 * @author Chandra Bhan
 */

@Slf4j
@Validated
@RestController
@Configuration
@RequestMapping("/user")
public class UserController {

	public static final String LOG_OP_INFO = "MFA_CONTROLLER";

	@Autowired
	private UserService userService;

	@Autowired
	private UserRequestMapper userRequestMapper;
	




	@InitBinder("userRequestDTO")
	protected void initBinderForUser(WebDataBinder binder) {
		binder.addValidators(new UserRequestValidator());
	}

	/**
	 * @param id
	 * @return User details of respective user_id
	 */
	@RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> getUserDetails(@NotNull @PathVariable String id) {
		

        	User user = userService.getUser(id);

      		if (user == null) {
     		
		throw new UserNotFoundException(ExceptionErrorCode.DATA_NOT_FOUND);
	}

		UserRequestDTO userRequestDTO = userRequestMapper.mapUserRequestDomainToDTO(user);

		return new ResponseEntity<>(userRequestDTO, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@NotNull @RequestBody @Valid UserRequestDTO userRequestDTO,
			BindingResult bindingResult) {
		//final Stopwatch stopwatch = Stopwatch.createUnstarted().start();
		
		processErrors(bindingResult);
		User user = userRequestMapper.mapUserRequestDTOToDomain(userRequestDTO);

		if (userService.getUser(user.getId()) != null) {
			throw new UserNotFoundException(ExceptionErrorCode.DUPLICATE_DATA_PERSIST_ERROR);
		}

		userService.add(user);

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
