package com.treasury.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treasury.beans.PaymentBean;
import com.treasury.beans.UserBean;
import com.treasury.dtos.PaymentDto;
import com.treasury.dtos.ReportDto;
import com.treasury.repositories.PaymentRepository;
import com.treasury.repositories.UserRepository;
import com.treasury.utils.DtoCreatorUtil;

@Service
public class ReportingService {

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private DtoCreatorUtil dtoCreatorUtil;

	public ReportDto getReport() {
		ReportDto reportDto = new ReportDto();
		List<PaymentBean> payments = paymentRepository.findAll();
		for (PaymentBean paymentBean : payments) {
			UserBean userBean = userRepository.findOne(paymentBean.getUserId());
			PaymentDto paymentDto = dtoCreatorUtil.createPaymentDto(
					paymentBean, userBean);
			reportDto.getPaymentDtos().add(paymentDto);
		}
		return reportDto;
	}

}
