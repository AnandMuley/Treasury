package com.treasury.controllers;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.treasury.dtos.DashboardDto;
import com.treasury.dtos.ReportDto;
import com.treasury.dtos.UserDto;
import com.treasury.services.DashboardService;
import com.treasury.services.ReportingService;
import com.treasury.services.UserService;

@Controller
public class HeaderController {

	@Autowired
	private UserService userService;

	@Autowired
	private DashboardService dashboardService;

	@Autowired
	private ReportingService reportingService;

	@RequestMapping(value = "administration")
	public String renderAdminPage() {
		return "Administration";
	}

	@RequestMapping(value = "users")
	public String renderUsers(Model model) {
		List<UserDto> userDtos = userService.getAll();
		model.addAttribute("users", userDtos);
		return "Users";
	}

	@RequestMapping(value = "payments")
	public String renderPayments(Model model) {
		List<UserDto> userDtos = userService.getAll();
		model.addAttribute("users", userDtos);
		return "Payments";
	}

	@RequestMapping(value = "dashboard")
	public String renderDashboard(Model model) {
		try {
			DashboardDto dashboardDto = dashboardService.getDashboardDetails();
			model.addAttribute("dashboardDto", dashboardDto);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "Dashboard";
	}

	@RequestMapping(value = "reports")
	public String renderReports(Model model) {
		ReportDto reportDto = reportingService.getReport();
		model.addAttribute("report", reportDto);
		return "Reports";
	}

}
