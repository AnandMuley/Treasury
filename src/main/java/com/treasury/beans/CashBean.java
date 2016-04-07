package com.treasury.beans;

import java.util.Date;

public class CashBean {

	private Date date;
	private Double amount;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
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
		return "CashBean [date=" + date + ", amount=" + amount + "]";
	}

}
