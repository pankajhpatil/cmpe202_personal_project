package com.cmpe202.ip1;

import java.util.regex.Pattern;

public class AmExCardValidator extends abstractValidator {

	public AmExCardValidator(abstractValidator nextValidator) {
		super(nextValidator);
	}

	@Override
	protected String getCardType(String cardNo) {
		if (cardNo != null && cardNo.length() == 15 && Pattern.matches("3[4|7][0-9]{13}", cardNo)) {
			return Constants._AMEX;
		} else if (nextValidator != null) {
			return nextValidator.getCardType(cardNo);
		}

		return Constants._INVALID;
	}

}
