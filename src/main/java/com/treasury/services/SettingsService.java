package com.treasury.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treasury.beans.SettingsBean;
import com.treasury.dtos.SettingsDto;
import com.treasury.repositories.SettingsRepository;
import com.treasury.utils.BeanCreatorUtil;
import com.treasury.utils.DtoCreatorUtil;

@Service
public class SettingsService {

	@Autowired
	private SettingsRepository settingsRepository;

	@Autowired
	private BeanCreatorUtil beanCreatorUtil;

	@Autowired
	private DtoCreatorUtil dtoCreatorUtil;

	public void createNew(SettingsDto settingsDto) {
		SettingsBean settingsBean = beanCreatorUtil
				.createSettingsBean(settingsDto);
		settingsRepository.save(settingsBean);
		settingsDto.setId(settingsBean.getId());
	}

	public SettingsDto findBy(String createdBy) {
		SettingsBean settingsBean = settingsRepository
				.findByCreatedBy(createdBy);
		SettingsDto settingsDto = null;
		if (settingsBean != null) {
			settingsDto = dtoCreatorUtil.createSettingsDto(settingsBean);
		}
		return settingsDto;
	}

	public void update(SettingsDto settingsDto) {
		SettingsBean settingsBean = beanCreatorUtil
				.createSettingsBean(settingsDto);
		settingsBean.setId(settingsDto.getId());
		settingsRepository.save(settingsBean);
	}

}
