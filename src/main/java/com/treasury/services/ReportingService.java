package com.treasury.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treasury.beans.PaymentBean;
import com.treasury.beans.ResidentBean;
import com.treasury.dtos.PaymentDto;
import com.treasury.dtos.ReportDto;
import com.treasury.repositories.PaymentRepository;
import com.treasury.repositories.ResidentRepository;
import com.treasury.utils.DtoCreatorUtil;

@Service
public class ReportingService {

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private ResidentRepository residentRepository;

	@Autowired
	private DtoCreatorUtil dtoCreatorUtil;

	/*
	 * Need to optimize below method
	 */
	public ReportDto getReport(String createdBy) {
		ReportDto reportDto = new ReportDto();
		List<ResidentBean> residentBeans = residentRepository
				.findByCreatedBy(createdBy);
		List<String> residentIds = new ArrayList<String>();
		for (ResidentBean residentBean : residentBeans) {
			residentIds.add(residentBean.getId());
		}
		List<PaymentBean> payments = paymentRepository
				.findAllByResidentIds(residentIds);
		for (PaymentBean paymentBean : payments) {
			ResidentBean residentBean = residentRepository.findOne(paymentBean
					.getResidentId());
			PaymentDto paymentDto = dtoCreatorUtil.createPaymentDto(
					paymentBean, residentBean);
			reportDto.getPaymentDtos().add(paymentDto);
		}
		return reportDto;
	}

}
