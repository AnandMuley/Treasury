package com.treasury.dtos;


public class ChequeDto {

	private String date;
	private String bankDetails;
	private String chequeNo;
	private Double amount;
	private String submittedDt;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
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

	public String getSubmittedDt() {
		return submittedDt;
	}

	public void setSubmittedDt(String submittedDt) {
		this.submittedDt = submittedDt;
	}

	@Override
	public String toString() {
		return "ChequeDto [date=" + date + ", bankDetails=" + bankDetails
				+ ", chequeNo=" + chequeNo + ", amount=" + amount
				+ ", submittedDt=" + submittedDt + "]";
	}

}
