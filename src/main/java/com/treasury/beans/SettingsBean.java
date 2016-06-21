package com.treasury.beans;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "settings")
public class SettingsBean {

	@Id
	private String id;
	private Double maintRate;
	private String createdBy;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getMaintRate() {
		return maintRate;
	}

	public void setMaintRate(Double maintRate) {
		this.maintRate = maintRate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public String toString() {
		return "SettingsBean [id=" + id + ", maintRate=" + maintRate
				+ ", createdBy=" + createdBy + "]";
	}

}
