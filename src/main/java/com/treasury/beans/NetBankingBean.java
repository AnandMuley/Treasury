package com.treasury.beans;


public class NetBankingBean {

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
		return "NetBankingBean [referenceNo=" + referenceNo + ", accountNo="
				+ accountNo + ", bankDetails=" + bankDetails + "]";
	}

}
