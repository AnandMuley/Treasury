package com.treasury.dtos;

import java.util.ArrayList;
import java.util.List;

public class DashboardDto {

	private String startDt;
	private Double expectedAmount;
	private List<ResidentDto> residentDtos = new ArrayList<ResidentDto>();

	public String getStartDt() {
		return startDt;
	}

	public void setStartDt(String startDt) {
		this.startDt = startDt;
	}

	public Double getExpectedAmount() {
		return expectedAmount;
	}

	public void setExpectedAmount(Double expectedAmount) {
		this.expectedAmount = expectedAmount;
	}

	public List<ResidentDto> getResidentDtos() {
		return residentDtos;
	}

	@Override
	public String toString() {
		return "DashboardDto [startDt=" + startDt + ", expectedAmount="
				+ expectedAmount + ", residentDtos=" + residentDtos + "]";
	}

}
