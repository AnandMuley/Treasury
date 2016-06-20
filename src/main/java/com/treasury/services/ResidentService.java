package com.treasury.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treasury.beans.ResidentBean;
import com.treasury.dtos.ResidentDto;
import com.treasury.repositories.ResidentRepository;
import com.treasury.utils.BeanCreatorUtil;
import com.treasury.utils.DtoCreatorUtil;

@Service
public class ResidentService {

	@Autowired
	private ResidentRepository residentRepository;

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private BeanCreatorUtil beanCreatorUtil;

	@Autowired
	private DtoCreatorUtil dtoCreatorUtil;

	@Autowired
	private PaymentCalculator paymentCalculator;

	public ResidentDto findById(String residentId) {
		ResidentBean residentBean = residentRepository.findOne(residentId);
		ResidentDto residentDto = dtoCreatorUtil
				.createResidentDto(residentBean);
		return residentDto;
	}

	public List<String> getResidentIds(String createdBy) {
		List<ResidentBean> residentBeans = residentRepository
				.findByCreatedBy(createdBy);
		List<String> residentIds = new ArrayList<String>();
		for (ResidentBean residentBean : residentBeans) {
			residentIds.add(residentBean.getId());
		}
		return residentIds;
	}

	public void create(ResidentDto residentDto) {
		ResidentBean residentBean = beanCreatorUtil
				.createResidentBean(residentDto);
		residentRepository.save(residentBean);
		residentDto.setId(residentBean.getId());
	}

	public List<ResidentDto> getAll(String createdBy) {
		List<ResidentBean> beans = residentRepository.findAll();
		List<ResidentDto> residentDtos = new ArrayList<ResidentDto>();
		for (ResidentBean residentBean : beans) {
			if (createdBy.equals(residentBean.getCreatedBy())) {
				ResidentDto residentDto = dtoCreatorUtil
						.createResidentDto(residentBean);
				residentDto.setAmountPayable(paymentCalculator
						.calculateAmountPayable(residentDto.getArea()));
				residentDtos.add(residentDto);
			}
		}
		return residentDtos;
	}

	public void delete(String id) {
		residentRepository.delete(id);
		paymentService.removeAll(id);
	}

	public void save(ResidentDto residentDto) {
		ResidentBean bean = residentRepository.findOne(residentDto.getId());
		bean.setContactNo(residentDto.getContactNo());
		bean.setFlatNo(residentDto.getFlatNo());
		bean.setName(residentDto.getName());
		residentRepository.save(bean);
	}

}
