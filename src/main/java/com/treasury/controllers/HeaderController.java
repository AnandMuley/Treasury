package com.treasury.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HeaderController {

	@RequestMapping(value="users")
	public String renderUsers(){
		return "Users";
	}
	
	@RequestMapping(value="payments")
	public String renderPayments(){
		return "Payments";
	}
	
}
