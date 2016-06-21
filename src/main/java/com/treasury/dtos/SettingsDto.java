package com.treasury.dtos;

public class SettingsDto {

	private String id;
	private String createdBy;
	private Double maintRate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Double getMaintRate() {
		return maintRate;
	}

	public void setMaintRate(Double maintRate) {
		this.maintRate = maintRate;
	}

	@Override
	public String toString() {
		return "SettingsDto [id=" + id + ", createdBy=" + createdBy
				+ ", maintRate=" + maintRate + "]";
	}

}
