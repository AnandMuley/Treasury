package com.treasury.utils;

import org.springframework.stereotype.Component;

import com.treasury.beans.UserBean;
import com.treasury.dtos.UserDto;

@Component
public class BeanCreatorUtil {

	public UserBean createUserBean(UserDto userDto) {
		UserBean userBean = new UserBean();
		userBean.setContactNo(userDto.getContactNo());
		userBean.setFlatNo(userDto.getFlatNo());
		userBean.setName(userDto.getName());
		userBean.setArea(userDto.getArea());
		return userBean;
	}

}
