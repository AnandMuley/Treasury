package com.treasury.dtos;

public class ResidentDto {

	private String id;
	private String name;
	private Long contactNo;
	private String flatNo;
	private Double amountDue;
	/*
	 * In Square Feet
	 */
	private Double area;
	private Double amountPayable;
	private String createdBy;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getContactNo() {
		return contactNo;
	}

	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}

	public String getFlatNo() {
		return flatNo;
	}

	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}

	public Double getAmountDue() {
		return amountDue;
	}

	public void setAmountDue(Double amountDue) {
		this.amountDue = amountDue;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	public Double getAmountPayable() {
		return amountPayable;
	}

	public void setAmountPayable(Double amountPayable) {
		this.amountPayable = amountPayable;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public String toString() {
		return "ResidentDto [id=" + id + ", name=" + name + ", contactNo="
				+ contactNo + ", flatNo=" + flatNo + ", amountDue=" + amountDue
				+ ", area=" + area + ", amountPayable=" + amountPayable
				+ ", createdBy=" + createdBy + "]";
	}

}
