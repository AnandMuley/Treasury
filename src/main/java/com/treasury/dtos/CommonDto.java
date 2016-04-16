package com.treasury.dtos;

import java.util.ArrayList;
import java.util.List;

public class CommonDto {

	protected List<String> validationErrors = new ArrayList<String>();

	public List<String> getValidationErrors() {
		return validationErrors;
	}

	@Override
	public String toString() {
		return "CommonDto [validationErrors=" + validationErrors + "]";
	}

}
