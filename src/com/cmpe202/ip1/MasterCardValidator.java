package com.cmpe202.ip1;

import java.util.regex.Pattern;

public class MasterCardValidator extends abstractValidator {

	public MasterCardValidator(abstractValidator nextValidator) {
		super(nextValidator);
	}

	@Override
	protected String getCardType(String cardNo) {
		if (cardNo != null && cardNo.length() == 16 && Pattern.matches("5[1-5][0-9]{14}", cardNo)) {
			return Constants._MASTERCARD;
		} else if (nextValidator != null) {
			return nextValidator.getCardType(cardNo);
		}

		return Constants._INVALID;
	}

}
