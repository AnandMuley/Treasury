package com.treasury.beans;

public class UserAmountBean {

	private String userId;
	private Double amount;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "UserAmountBean [userId=" + userId + ", amount=" + amount + "]";
	}

}
