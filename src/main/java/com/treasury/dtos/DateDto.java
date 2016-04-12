package com.treasury.dtos;

import java.util.HashMap;
import java.util.Map;

public class DateDto {

	private Integer month;
	private Integer year;
	private String monthName;
	private Map<Integer, String> monthNumNameMap = new HashMap<Integer, String>(
			12);

	public DateDto() {
		populateMonthNamesMap();
	}

	private void populateMonthNamesMap() {
		monthNumNameMap.put(1, "Jan");
		monthNumNameMap.put(2, "Feb");
		monthNumNameMap.put(3, "Mar");
		monthNumNameMap.put(4, "Apr");

		monthNumNameMap.put(5, "May");
		monthNumNameMap.put(6, "Jun");
		monthNumNameMap.put(7, "Jul");
		monthNumNameMap.put(8, "Aug");

		monthNumNameMap.put(9, "Sep");
		monthNumNameMap.put(10, "Oct");
		monthNumNameMap.put(11, "Nov");
		monthNumNameMap.put(12, "Dec");
	}

	public DateDto(Integer month, Integer year) {
		super();
		populateMonthNamesMap();
		this.month = month;
		this.year = year;
		this.monthName = monthNumNameMap.get(month);
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
		this.monthName = monthNumNameMap.get(month);
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getMonthName() {
		return monthName;
	}

	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}

	@Override
	public String toString() {
		return "DateDto [month=" + month + ", year=" + year + ", monthName="
				+ monthName + "]";
	}

}
