package com.treasury.beans;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "payments")
public class PaymentBean {

	@Id
	private String id;
	private String residentId;
	private String mode;
	private Double amount;
	private Date paymentDt;
	private ChequeBean chequeBean;
	private NetBankingBean netBankingBean;
	private DateBean fromDate = new DateBean();
	private DateBean toDate = new DateBean();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getResidentId() {
		return residentId;
	}

	public void setResidentId(String residentId) {
		this.residentId = residentId;
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

	public DateBean getFromDate() {
		return fromDate;
	}

	public void setFromDate(DateBean fromDate) {
		this.fromDate = fromDate;
	}

	public DateBean getToDate() {
		return toDate;
	}

	public void setToDate(DateBean toDate) {
		this.toDate = toDate;
	}

	@Override
	public String toString() {
		return "PaymentBean [id=" + id + ", residentId=" + residentId
				+ ", mode=" + mode + ", amount=" + amount + ", paymentDt="
				+ paymentDt + ", chequeBean=" + chequeBean
				+ ", netBankingBean=" + netBankingBean + ", fromDate="
				+ fromDate + ", toDate=" + toDate + "]";
	}

}
