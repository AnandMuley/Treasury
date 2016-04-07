package com.treasury.beans;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "payments")
public class PaymentBean {

	@Id
	private String id;
	private String userId;
	private String mode;
	private ChequeBean chequeBean;
	private NetBankingBean netBankingBean;
	private CashBean cashBean;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public ChequeBean getChequeBean() {
		return chequeBean;
	}

	public void setChequeBean(ChequeBean chequeBean) {
		this.chequeBean = chequeBean;
	}

	public NetBankingBean getNetBankingBean() {
		return netBankingBean;
	}

	public void setNetBankingBean(NetBankingBean netBankingBean) {
		this.netBankingBean = netBankingBean;
	}

	public CashBean getCashBean() {
		return cashBean;
	}

	public void setCashBean(CashBean cashBean) {
		this.cashBean = cashBean;
	}

	@Override
	public String toString() {
		return "PaymentBean [id=" + id + ", userId=" + userId + ", mode="
				+ mode + ", chequeBean=" + chequeBean + ", netBankingBean="
				+ netBankingBean + ", cashBean=" + cashBean + "]";
	}

}
