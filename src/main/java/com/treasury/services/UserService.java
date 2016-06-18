package com.treasury.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treasury.beans.UserBean;
import com.treasury.dtos.UserDto;
import com.treasury.repositories.UserRepository;
import com.treasury.utils.BeanCreatorUtil;
import com.treasury.utils.DtoCreatorUtil;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private DtoCreatorUtil dtoCreatorUtil;

	@Autowired
	private BeanCreatorUtil beanCreatorUtil;

	public UserDto findById(String userId) {
		UserBean userBean = userRepository.findOne(userId);
		UserDto userDto = dtoCreatorUtil.createUserDto(userBean);
		return userDto;
	}

	public UserBean find(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}

	public void create(UserDto userDto) {
		UserBean userBean = beanCreatorUtil.createUserBean(userDto);
		userRepository.save(userBean);
		userDto.setId(userBean.getId());
	}
}
