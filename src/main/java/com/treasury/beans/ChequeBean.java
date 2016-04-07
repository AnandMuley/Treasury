package com.treasury.beans;

import java.util.Date;

public class ChequeBean {

	private Date date;
	private String bankDetails;
	private String chequeNo;
	private Double amount;
	private Date submittedDt;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getBankDetails() {
		return bankDetails;
	}

	public void setBankDetails(String bankDetails) {
		this.bankDetails = bankDetails;
	}

	public String getChequeNo() {
		return chequeNo;
	}

	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getSubmittedDt() {
		return submittedDt;
	}

	public void setSubmittedDt(Date submittedDt) {
		this.submittedDt = submittedDt;
	}

	@Override
	public String toString() {
		return "ChequeBean [date=" + date + ", bankDetails=" + bankDetails
				+ ", chequeNo=" + chequeNo + ", amount=" + amount
				+ ", submittedDt=" + submittedDt + "]";
	}

}
