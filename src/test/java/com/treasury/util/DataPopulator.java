package com.treasury.util;

import com.treasury.dtos.DateDto;
import com.treasury.dtos.PaymentDto;
import com.treasury.dtos.ResidentDto;
import com.treasury.dtos.UserDto;

public class DataPopulator {

	public ResidentDto createResidentDto(String createdBy) {
		ResidentDto residentDto = new ResidentDto();
		residentDto.setName("Resident1");
		residentDto.setFlatNo("A-101");
		residentDto.setCreatedBy(createdBy);
		residentDto.setContactNo(9870089700l);
		residentDto.setArea(1200d);
		return residentDto;
	}

	public PaymentDto createPaymentDto(String residentId) {
		PaymentDto paymentDto = new PaymentDto();
		paymentDto.setAmount(1000d);
		paymentDto.setMode("cash");
		paymentDto.setResidentId(residentId);
		paymentDto.setPaymentDt("02-02-2016");
		DateDto fromDateDto = new DateDto(1, 2016);
		paymentDto.setFromDateDto(fromDateDto);
		DateDto toDateDto = new DateDto(2, 2016);
		paymentDto.setToDateDto(toDateDto);
		return paymentDto;
	}

	public UserDto createUserDto(String name) {
		UserDto userDto = new UserDto();
		userDto.setEmailId("user@gmail.com");
		userDto.setPassword("password123");
		userDto.setUsername(name);
		return userDto;
	}

}
