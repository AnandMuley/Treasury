package com.treasury.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treasury.beans.UserBean;
import com.treasury.dtos.UserDto;
import com.treasury.repositories.UserRepository;
import com.treasury.utils.BeanCreatorUtil;
import com.treasury.utils.DtoCreatorUtil;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private BeanCreatorUtil beanCreatorUtil;

	@Autowired
	private DtoCreatorUtil dtoCreatorUtil;

	@Autowired
	private PaymentCalculator paymentCalculator;

	public UserDto findById(String userId) {
		UserBean userBean = userRepository.findOne(userId);
		UserDto userDto = dtoCreatorUtil.createUserDto(userBean);
		return userDto;
	}

	public void create(UserDto userDto) {
		UserBean userBean = beanCreatorUtil.createUserBean(userDto);
		userRepository.save(userBean);
		userDto.setId(userBean.getId());
	}

	public List<UserDto> getAll() {
		List<UserBean> beans = userRepository.findAll();
		List<UserDto> userDtos = new ArrayList<UserDto>();
		for (UserBean userBean : beans) {
			UserDto userDto = dtoCreatorUtil.createUserDto(userBean);
			userDto.setAmountPayable(paymentCalculator
					.calculateAmountPayable(userDto.getArea()));
			userDtos.add(userDto);
		}
		return userDtos;
	}

	public void delete(String id) {
		userRepository.delete(id);
		paymentService.removeAll(id);
	}

	public void save(UserDto userDto) {
		UserBean bean = userRepository.findOne(userDto.getId());
		bean.setContactNo(userDto.getContactNo());
		bean.setFlatNo(userDto.getFlatNo());
		bean.setName(userDto.getName());
		userRepository.save(bean);
	}

}
