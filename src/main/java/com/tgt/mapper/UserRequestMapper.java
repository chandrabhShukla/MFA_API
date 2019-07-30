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
		userRequestDTO.setName(user.getName());
		
		return userRequestDTO;
	}

	public User mapUserRequestDTOToDomain(UserRequestDTO userRequestDTO) {
		User user = new User();

		user.setId(userRequestDTO.getId());
		user.setName(userRequestDTO.getName());
		
		return user;
	}
}