package com.treasury.beans;

import java.util.Date;

public class ChequeBean {

	private String bankDetails;
	private String chequeNo;
	private Date chequeDt;

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

	public Date getChequeDt() {
		return chequeDt;
	}

	public void setChequeDt(Date chequeDt) {
		this.chequeDt = chequeDt;
	}

	@Override
	public String toString() {
		return "ChequeBean [bankDetails=" + bankDetails + ", chequeNo="
				+ chequeNo + ", chequeDt=" + chequeDt + "]";
	}

}
