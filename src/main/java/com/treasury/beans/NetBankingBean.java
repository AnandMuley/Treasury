package com.treasury.beans;

import java.util.Date;

public class NetBankingBean {

	private String referenceNo;
	private String accountNo;
	private Date date;
	private Double amount;
	private String bankDetails;

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

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

	public String getBankDetails() {
		return bankDetails;
	}

	public void setBankDetails(String bankDetails) {
		this.bankDetails = bankDetails;
	}

	@Override
	public String toString() {
		return "NetBankingBean [referenceNo=" + referenceNo + ", accountNo="
				+ accountNo + ", date=" + date + ", amount=" + amount
				+ ", bankDetails=" + bankDetails + "]";
	}

}
