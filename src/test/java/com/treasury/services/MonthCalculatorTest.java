package com.treasury.services;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.treasury.dtos.DateDto;

public class MonthCalculatorTest {

	private DateCalculator calculator;

	@BeforeClass
	public void init() {
		calculator = new DateCalculator();
	}

	@Test
	public void shouldCalculateNoOfMonths() {
		// GIVEN
		int expected = 4;
		DateDto fromDateDto = new DateDto(11, 2015);
		DateDto toDateDto = new DateDto(2, 2016);

		// WHEN
		int actual = calculator.getNoOfMonths(fromDateDto, toDateDto);
		
		// THEN
		Assert.assertEquals(actual, expected);
		
	}

}
