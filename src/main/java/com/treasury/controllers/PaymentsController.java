package com.treasury.controllers;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.treasury.dtos.PaymentDto;
import com.treasury.dtos.UserDto;
import com.treasury.exceptions.InvalidPaymentModeException;
import com.treasury.services.PaymentService;
import com.treasury.services.UserService;

@Controller
@RequestMapping("payments")
public class PaymentsController {

	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addPayment(PaymentDto paymentDto, Model model) {
		try {
			paymentService.create(paymentDto);
			List<UserDto> userDtos = userService.getAll();
			model.addAttribute("users", userDtos);
			model.addAttribute("message", "Details saved successfully !");
		} catch (InvalidPaymentModeException e) {
			model.addAttribute("message", e.getMessage());
		} catch (ParseException e) {
			model.addAttribute("message", "Invalid Date Format");
		}
		return "Payments";
	}

}
