package com.treasury.services;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treasury.beans.ResidentBean;
import com.treasury.dtos.DashboardDto;
import com.treasury.dtos.ResidentDto;
import com.treasury.repositories.ResidentRepository;
import com.treasury.utils.DtoCreatorUtil;

@Service
public class DashboardService {

	@Autowired
	private ResidentRepository residentRepository;

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private DateCalculator dateCalculator;

	@Autowired
	private DtoCreatorUtil dtoCreatorUtil;

	public DashboardDto getDashboardDetails(String createdBy)
			throws ParseException {

		DashboardDto dashboardDto = new DashboardDto();
		dashboardDto.setStartDt(dateCalculator.getStartDate());
		// Get all residents
		List<ResidentBean> residentBeans = residentRepository
				.findByCreatedBy(createdBy);

		for (ResidentBean residentBean : residentBeans) {
			ResidentDto residentDto = dtoCreatorUtil
					.createResidentDto(residentBean);
			String residentId = residentBean.getId();
			// Calculate amount payable
			Double amountPayable = paymentService.calculateAmountPayable(
					residentId, createdBy);
			residentDto.setAmountPayable(amountPayable);
			// Calculate amount due
			residentDto.setAmountDue(paymentService.calculateAmountDue(
					residentId, createdBy));
			dashboardDto.getResidentDtos().add(residentDto);
		}

		return dashboardDto;
	}

}
