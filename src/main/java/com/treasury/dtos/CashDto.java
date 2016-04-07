package com.treasury.dtos;


public class CashDto {

	private String date;
	private Double amount;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "CashDto [date=" + date + ", amount=" + amount + "]";
	}

}
