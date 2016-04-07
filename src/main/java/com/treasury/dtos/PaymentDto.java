package com.treasury.dtos;

public class PaymentDto {

	private String id;
	private String userId;
	private String mode;
	private ChequeDto chequeDto;
	private NetBankingDto netBankingDto;
	private CashDto cashDto;

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

	public CashDto getCashDto() {
		return cashDto;
	}

	public void setCashDto(CashDto cashDto) {
		this.cashDto = cashDto;
	}

	@Override
	public String toString() {
		return "PaymentDto [id=" + id + ", userId=" + userId + ", mode=" + mode
				+ ", chequeDto=" + chequeDto + ", netBankingDto="
				+ netBankingDto + ", cashDto=" + cashDto + "]";
	}

}
