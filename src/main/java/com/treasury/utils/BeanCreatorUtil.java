package com.treasury.utils;

import org.springframework.stereotype.Component;

import com.treasury.beans.ResidentBean;
import com.treasury.beans.SettingsBean;
import com.treasury.beans.UserBean;
import com.treasury.dtos.ResidentDto;
import com.treasury.dtos.SettingsDto;
import com.treasury.dtos.UserDto;

@Component
public class BeanCreatorUtil {

	public ResidentBean createResidentBean(ResidentDto residentDto) {
		ResidentBean residentBean = new ResidentBean();
		residentBean.setContactNo(residentDto.getContactNo());
		residentBean.setFlatNo(residentDto.getFlatNo());
		residentBean.setName(residentDto.getName());
		residentBean.setArea(residentDto.getArea());
		residentBean.setCreatedBy(residentDto.getCreatedBy());
		residentBean.setGender(residentDto.getGender());
		return residentBean;
	}

	public UserBean createUserBean(UserDto userDto) {
		UserBean userBean = new UserBean();
		userBean.setEmailId(userDto.getEmailId());
		userBean.setPassword(userDto.getPassword());
		userBean.setUsername(userDto.getUsername());
		return userBean;
	}

	public SettingsBean createSettingsBean(SettingsDto settingsDto) {
		SettingsBean settingsBean = new SettingsBean();
		settingsBean.setCreatedBy(settingsDto.getCreatedBy());
		settingsBean.setMaintRate(settingsDto.getMaintRate());
		return settingsBean;
	}

}
