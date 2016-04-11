package com.treasury.dtos;

public class NetBankingDto {

	private String referenceNo;
	private String accountNo;
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

	public String getBankDetails() {
		return bankDetails;
	}

	public void setBankDetails(String bankDetails) {
		this.bankDetails = bankDetails;
	}

	@Override
	public String toString() {
		return "NetBankingDto [referenceNo=" + referenceNo + ", accountNo="
				+ accountNo + ", bankDetails=" + bankDetails + "]";
	}

}
