package com.tgt.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tgt.domain.User;
import com.tgt.dto.UserRequestDTO;

@Component
public class UserRequestMapper {



	public UserRequestDTO mapUserRequestDomainToDTO(User user) {
		UserRequestDTO userRequestDTO = new UserRequestDTO();

		userRequestDTO.setId(user.getId());
		userRequestDTO.setFirstName(user.getFirstName());
		userRequestDTO.setLastName(user.getLastName());
		userRequestDTO.setDeviceName(user.getDeviceName());
		userRequestDTO.setLocation(user.getLocation());
		userRequestDTO.setMobileNumber(user.getMobileNumber());
		userRequestDTO.setMobile(user.getMobile());
		return userRequestDTO;
	}

	public User mapUserRequestDTOToDomain(UserRequestDTO userRequestDTO) {
		User user = new User();

		user.setId(userRequestDTO.getId());
		user.setFirstName(userRequestDTO.getFirstName());
        user.setLastName(userRequestDTO.getLastName());
        user.setLocation(userRequestDTO.getLocation());
        user.setMobile(userRequestDTO.getMobile());
        user.setMobileNumber(userRequestDTO.getMobileNumber());
        user.setDeviceName(userRequestDTO.getDeviceName());        
		return user;
	}
}