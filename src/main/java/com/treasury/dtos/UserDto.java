package com.treasury.dtos;

public class UserDto {

	private String id;
	private String name;
	private long contactNo;
	private String flatNo;
	private Double amountDue;

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

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
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

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", name=" + name + ", contactNo="
				+ contactNo + ", flatNo=" + flatNo + ", amountDue=" + amountDue
				+ "]";
	}

}
