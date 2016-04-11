package com.treasury.dtos;

public class PaymentDto {

	private String id;
	private String userId;
	private String mode;
	private Double amount;
	private String paymentDt;
	private ChequeDto chequeDto;
	private NetBankingDto netBankingDto;

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

	public String getPaymentDt() {
		return paymentDt;
	}

	public void setPaymentDt(String paymentDt) {
		this.paymentDt = paymentDt;
	}

	public ChequeDto getChequeDto() {
		return chequeDto;
	}

	public void setChequeDto(ChequeDto chequeDto) {
		this.chequeDto = chequeDto;
	}

	public NetBankingDto getNetBankingDto() {
		return netBankingDto;
	}

	public void setNetBankingDto(NetBankingDto netBankingDto) {
		this.netBankingDto = netBankingDto;
	}

	@Override
	public String toString() {
		return "PaymentDto [id=" + id + ", userId=" + userId + ", mode=" + mode
				+ ", amount=" + amount + ", paymentDt=" + paymentDt
				+ ", chequeDto=" + chequeDto + ", netBankingDto="
				+ netBankingDto + "]";
	}

}
