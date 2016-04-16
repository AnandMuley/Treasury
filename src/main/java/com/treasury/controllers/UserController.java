package com.treasury.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.treasury.dtos.UserDto;
import com.treasury.services.UserService;
import com.treasury.services.ValidationService;

@Controller
@RequestMapping(value = "users")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private ValidationService validationService;

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String createUser(UserDto userDto, Model model) {
		validationService.validate(userDto);
		if (CollectionUtils.isEmpty(userDto.getValidationErrors())) {
			userService.create(userDto);
			model.addAttribute("message", "User added successfully !");
			clearAttributes(userDto);
		} else {
			model.addAttribute("userDto", userDto);
		}
		List<UserDto> userDtos = userService.getAll();
		model.addAttribute("users", userDtos);
		return "Users";
	}

	private void clearAttributes(UserDto userDto) {
		userDto.setAmountDue(null);
		userDto.setArea(null);
		userDto.setContactNo(null);
		userDto.setFlatNo(null);
		userDto.setId(null);
		userDto.setName(null);
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String saveUser(UserDto userDto, Model model) {
		userService.save(userDto);
		model.addAttribute("message", "Details saved successfully !");
		List<UserDto> userDtos = userService.getAll();
		model.addAttribute("users", userDtos);
		return "Users";
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String deleteUser(UserDto userDto, Model model) {
		userService.delete(userDto.getId());
		List<UserDto> userDtos = userService.getAll();
		model.addAttribute("users", userDtos);
		return "Users";
	}

}
