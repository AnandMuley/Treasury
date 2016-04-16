package com.treasury.controllers;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.treasury.dtos.PaymentDto;
import com.treasury.dtos.UserDto;
import com.treasury.exceptions.InvalidPaymentModeException;
import com.treasury.services.PaymentService;
import com.treasury.services.UserService;
import com.treasury.services.ValidationService;

@Controller
@RequestMapping("payments")
public class PaymentsController {

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private UserService userService;

	@Autowired
	private ValidationService validationService;

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addPayment(PaymentDto paymentDto, Model model) {
		try {
			validationService.validate(paymentDto);
			if (CollectionUtils.isEmpty(paymentDto.getValidationErrors())) {
				paymentService.create(paymentDto);
				model.addAttribute("message", "Details saved successfully !");
				model.addAttribute("paymentDto", new PaymentDto());
			}
			List<UserDto> userDtos = userService.getAll();
			model.addAttribute("users", userDtos);
		} catch (InvalidPaymentModeException e) {
			model.addAttribute("message", e.getMessage());
		} catch (ParseException e) {
			model.addAttribute("message", "Invalid Date Format");
		}
		return "Payments";
	}

}
