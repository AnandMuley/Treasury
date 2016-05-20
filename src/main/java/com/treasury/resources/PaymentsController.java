package com.treasury.resources;

import java.text.ParseException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;

import com.treasury.dtos.PaymentDto;
import com.treasury.dtos.UserDto;
import com.treasury.exceptions.InvalidPaymentModeException;
import com.treasury.services.PaymentCalculator;
import com.treasury.services.PaymentService;
import com.treasury.services.UserService;
import com.treasury.services.ValidationService;

@Component
@Path("payments/{uid}")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PaymentsController {

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private UserService userService;

	@Autowired
	private ValidationService validationService;

	@Autowired
	private PaymentCalculator paymentCalculator;

	@GET
	@Path("amountpayable")
	public Response getAmountPayable(@PathParam("uid") String userId) {
		Response response = null;
		try {
			Double amountPayable = paymentService
					.calculateAmountPayable(userId);
			PaymentDto paymentDto = new PaymentDto();
			paymentDto.setAmountPayable(amountPayable);
			response = Response.ok(paymentDto).build();
		} catch (ParseException e) {
			e.printStackTrace();
			response = Response.serverError().build();
		}
		return response;
	}

	@POST
	public Response addPayment(PaymentDto paymentDto, Model model) {
		Response response = null;
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
			response = Response.status(Response.Status.BAD_REQUEST)
					.entity(e.getMessage()).build();
		} catch (ParseException e) {
			response = Response.status(Response.Status.BAD_REQUEST)
					.entity("Invalid Date Format").build();
		}
		return response;
	}

}
