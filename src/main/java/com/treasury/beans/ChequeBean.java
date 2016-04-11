package com.treasury.beans;

import java.util.Date;

public class ChequeBean {

	private String bankDetails;
	private String chequeNo;
	private Date submittedDt;

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

	public Date getSubmittedDt() {
		return submittedDt;
	}

	public void setSubmittedDt(Date submittedDt) {
		this.submittedDt = submittedDt;
	}

	@Override
	public String toString() {
		return "ChequeBean [bankDetails=" + bankDetails + ", chequeNo="
				+ chequeNo + ", submittedDt=" + submittedDt + "]";
	}

}
