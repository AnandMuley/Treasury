package com.treasury.beans;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "payments")
public class PaymentBean {

	@Id
	private String id;
	private String userId;
	private String mode;
	private Double amount;
	private Date paymentDt;
	private ChequeBean chequeBean;
	private NetBankingBean netBankingBean;

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

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getPaymentDt() {
		return paymentDt;
	}

	public void setPaymentDt(Date paymentDt) {
		this.paymentDt = paymentDt;
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

	@Override
	public String toString() {
		return "PaymentBean [id=" + id + ", userId=" + userId + ", mode="
				+ mode + ", amount=" + amount + ", paymentDt=" + paymentDt
				+ ", chequeBean=" + chequeBean + ", netBankingBean="
				+ netBankingBean + "]";
	}

}
