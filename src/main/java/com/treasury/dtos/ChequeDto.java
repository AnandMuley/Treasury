package com.treasury.dtos;

public class ChequeDto {

	private String bankDetails;
	private String chequeNo;
	private String chequeDt;

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

	public String getChequeDt() {
		return chequeDt;
	}

	public void setChequeDt(String chequeDt) {
		this.chequeDt = chequeDt;
	}

	@Override
	public String toString() {
		return "ChequeDto [bankDetails=" + bankDetails + ", chequeNo="
				+ chequeNo + ", chequeDt=" + chequeDt + "]";
	}

}
