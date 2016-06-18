package com.treasury.resources;

import java.text.ParseException;

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
import org.springframework.util.CollectionUtils;

import com.treasury.dtos.PaymentDto;
import com.treasury.exceptions.InvalidPaymentModeException;
import com.treasury.services.PaymentCalculator;
import com.treasury.services.PaymentService;
import com.treasury.services.ResidentService;
import com.treasury.services.ValidationService;

@Component
@Path("payments")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PaymentsController {

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private ResidentService residentService;

	@Autowired
	private ValidationService validationService;

	@Autowired
	private PaymentCalculator paymentCalculator;

	@GET
	@Path("{rid}/amountpayable")
	public Response getAmountPayable(@PathParam("rid") String residentId) {
		Response response = null;
		try {
			Double amountPayable = paymentService
					.calculateAmountPayable(residentId);
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
	public Response addPayment(PaymentDto paymentDto) {
		Response response = Response.ok().build();
		try {
			validationService.validate(paymentDto);
			if (!CollectionUtils.isEmpty(paymentDto.getValidationErrors())) {
				response = Response.status(Response.Status.BAD_REQUEST).build();
			} else {
				paymentService.create(paymentDto);
			}
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
