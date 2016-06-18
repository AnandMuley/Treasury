package com.treasury.services;

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

	public ReportDto getReport() {
		ReportDto reportDto = new ReportDto();
		List<PaymentBean> payments = paymentRepository.findAll();
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
