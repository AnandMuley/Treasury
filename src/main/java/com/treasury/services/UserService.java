package com.treasury.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treasury.beans.UserBean;
import com.treasury.dtos.UserDto;
import com.treasury.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void create(UserDto userDto) {
		UserBean userBean = new UserBean();
		userBean.setContactNo(userDto.getContactNo());
		userBean.setFlatNo(userDto.getFlatNo());
		userBean.setName(userDto.getName());
		userRepository.save(userBean);
		userDto.setId(userBean.getId());
	}

	public List<UserDto> getAll() {
		List<UserBean> beans = userRepository.findAll();
		List<UserDto> userDtos = new ArrayList<UserDto>();
		for (UserBean userBean : beans) {
			UserDto userDto = new UserDto();
			userDto.setContactNo(userBean.getContactNo());
			userDto.setFlatNo(userBean.getFlatNo());
			userDto.setId(userBean.getId());
			userDto.setName(userBean.getName());
			userDtos.add(userDto);
		}
		return userDtos;
	}

}
