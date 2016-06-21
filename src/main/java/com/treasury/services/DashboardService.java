package com.treasury.services;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treasury.beans.ResidentBean;
import com.treasury.dtos.DashboardDto;
import com.treasury.dtos.ResidentDto;
import com.treasury.repositories.ResidentRepository;

@Service
public class DashboardService {

	@Autowired
	private ResidentRepository residentRepository;

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private DateCalculator dateCalculator;

	public DashboardDto getDashboardDetails(String createdBy)
			throws ParseException {

		DashboardDto dashboardDto = new DashboardDto();
		dashboardDto.setStartDt(dateCalculator.getStartDate());
		// Get all residents
		List<ResidentBean> residentBeans = residentRepository
				.findByCreatedBy(createdBy);

		for (ResidentBean residentBean : residentBeans) {
			ResidentDto residentDto = new ResidentDto();
			String residentId = residentBean.getId();
			// Calculate amount payable
			Double amountPayable = paymentService
					.calculateAmountPayable(residentId);
			residentDto.setAmountPayable(amountPayable);
			// Calculate amount due
			residentDto.setAmountDue(paymentService.calculateAmountDue(
					residentId, createdBy));
			residentDto.setContactNo(residentBean.getContactNo());
			residentDto.setFlatNo(residentBean.getFlatNo());
			residentDto.setId(residentBean.getId());
			residentDto.setName(residentBean.getName());
			dashboardDto.getResidentDtos().add(residentDto);
		}

		return dashboardDto;
	}

}
