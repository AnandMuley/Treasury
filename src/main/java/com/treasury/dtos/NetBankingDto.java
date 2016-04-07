package com.treasury.dtos;


public class NetBankingDto {

	private String referenceNo;
	private String accountNo;
	private String date;
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

	public String getBankDetails() {
		return bankDetails;
	}

	public void setBankDetails(String bankDetails) {
		this.bankDetails = bankDetails;
	}

	@Override
	public String toString() {
		return "NetBankingDto [referenceNo=" + referenceNo + ", accountNo="
				+ accountNo + ", date=" + date + ", amount=" + amount
				+ ", bankDetails=" + bankDetails + "]";
	}

}
