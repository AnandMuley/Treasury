package com.treasury.dtos;

public class PaymentDto extends CommonDto {

	private String id;
	private String residentId;
	private String mode;
	private Double amount;
	private String paymentDt;
	private ChequeDto chequeDto;
	private NetBankingDto netBankingDto;
	private DateDto fromDateDto;
	private DateDto toDateDto;
	private String name;
	private Double amountPayable;

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

	public DateDto getFromDateDto() {
		return fromDateDto;
	}

	public void setFromDateDto(DateDto fromDateDto) {
		this.fromDateDto = fromDateDto;
	}

	public DateDto getToDateDto() {
		return toDateDto;
	}

	public void setToDateDto(DateDto toDateDto) {
		this.toDateDto = toDateDto;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getAmountPayable() {
		return amountPayable;
	}

	public void setAmountPayable(Double amountPayable) {
		this.amountPayable = amountPayable;
	}

	@Override
	public String toString() {
		return "PaymentDto [id=" + id + ", residentId=" + residentId
				+ ", mode=" + mode + ", amount=" + amount + ", paymentDt="
				+ paymentDt + ", chequeDto=" + chequeDto + ", netBankingDto="
				+ netBankingDto + ", fromDateDto=" + fromDateDto
				+ ", toDateDto=" + toDateDto + ", name=" + name
				+ ", amountPayable=" + amountPayable + "]";
	}

}
