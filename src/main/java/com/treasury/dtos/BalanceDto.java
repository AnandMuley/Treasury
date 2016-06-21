package com.treasury.dtos;

public class BalanceDto {

	private String residentId;
	private Double payable;
	private Double paid;
	private Double due;

	public String getResidentId() {
		return residentId;
	}

	public void setResidentId(String residentId) {
		this.residentId = residentId;
	}

	public Double getPayable() {
		return payable;
	}

	public void setPayable(Double payable) {
		this.payable = payable;
	}

	public Double getPaid() {
		return paid;
	}

	public void setPaid(Double paid) {
		this.paid = paid;
	}

	public Double getDue() {
		return due;
	}

	public void setDue(Double due) {
		this.due = due;
	}

	@Override
	public String toString() {
		return "BalanceDto [residentId=" + residentId + ", payable=" + payable
				+ ", paid=" + paid + ", due=" + due + "]";
	}

}
