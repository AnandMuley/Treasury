package com.treasury.beans;

public class DateBean {

	private Integer month;
	private Integer year;

	public DateBean(Integer month, Integer year) {
		super();
		this.month = month;
		this.year = year;
	}

	public DateBean() {
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "DateBean [month=" + month + ", year=" + year + "]";
	}

}
