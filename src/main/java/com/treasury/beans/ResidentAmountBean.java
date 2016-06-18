package com.treasury.beans;

public class ResidentAmountBean {

	private String residentId;
	private Double amount;

	public String getResidentId() {
		return residentId;
	}

	public void setResidentId(String residentId) {
		this.residentId = residentId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "ResidentAmountBean [residentId=" + residentId + ", amount="
				+ amount + "]";
	}

}
