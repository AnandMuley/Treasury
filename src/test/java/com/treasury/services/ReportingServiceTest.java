package com.treasury.services;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.treasury.config.TreasuryRootConfig;
import com.treasury.dtos.PaymentDto;
import com.treasury.dtos.ReportDto;
import com.treasury.dtos.ResidentDto;
import com.treasury.dtos.UserDto;
import com.treasury.exceptions.InvalidPaymentModeException;

public class ReportingServiceTest extends TreasuryRootConfig {

	@Autowired
	private ReportingService reportingService;

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private ResidentService residentService;

	@Autowired
	private UserService userService;

	private String createdBy;

	@BeforeMethod
	public void setUp() throws InvalidPaymentModeException, ParseException {
		UserDto userDtoA = dataPopulator.createUserDto("UserA");
		userService.create(userDtoA);
		createdBy = userDtoA.getId();
		ResidentDto residentDto = dataPopulator.createResidentDto(createdBy);
		residentService.create(residentDto);
		String residentId = residentDto.getId();
		PaymentDto paymentDto = dataPopulator.createPaymentDto(residentId);
		paymentService.create(paymentDto);
	}

	@Test
	public void shouldReturnPaymentReports() {
		// GIVEN
		UserDto userDtoB = dataPopulator.createUserDto("UserB");
		userService.create(userDtoB);
		// String createdBy = userDtoB.getId();

		// WHEN
		ReportDto actualReportDto = reportingService.getReport(createdBy);

		// THEN
		Assert.assertEquals(actualReportDto.getPaymentDtos().size(), 1);
	}

}
