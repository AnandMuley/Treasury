package com.treasury.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treasury.beans.UserBean;
import com.treasury.dtos.UserDto;
import com.treasury.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public void create(UserDto userDto){
		UserBean userBean = new UserBean();
		userBean.setContactNo(userDto.getContactNo());
		userBean.setFlatNo(userDto.getFlatNo());
		userBean.setName(userDto.getName());
		userRepository.save(userBean);
		userDto.setId(userBean.getId());
	}
	
}
