package com.cmpe202.ip1;

import java.util.regex.Pattern;

public class GenericValidator extends abstractValidator {

	public GenericValidator(abstractValidator nextValidator) {
		super(nextValidator);
	}

	@Override
	protected String getCardType(String cardNo) {
		if (cardNo == null || !Pattern.matches("[0-9]*", cardNo)) {
			return Constants._INVALID;
		} else if (nextValidator != null) {
			return nextValidator.getCardType(cardNo);
		}

		return Constants._INVALID;
	}

}
