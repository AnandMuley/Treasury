package com.treasury.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.treasury.dtos.UserDto;
import com.treasury.services.UserService;

@Controller
@RequestMapping(value = "users")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String createUser(UserDto userDto, Model model) {
		userService.create(userDto);
		model.addAttribute("message", "User added successfully !");
		List<UserDto> userDtos = userService.getAll();
		model.addAttribute("users", userDtos);
		return "Users";
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
