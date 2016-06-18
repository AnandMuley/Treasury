package com.treasury.resources;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.treasury.dtos.DashboardDto;
import com.treasury.dtos.ResidentDto;
import com.treasury.services.DashboardService;
import com.treasury.services.ResidentService;

@Controller
public class HeaderController {

	@Autowired
	private ResidentService userService;

	@Autowired
	private DashboardService dashboardService;

	@RequestMapping(value = "payments")
	public String renderPayments(Model model) {
		List<ResidentDto> userDtos = userService.getAll();
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

}
