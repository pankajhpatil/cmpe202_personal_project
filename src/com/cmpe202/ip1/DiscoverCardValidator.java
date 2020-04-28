package com.cmpe202.ip1;

public class DiscoverCardValidator extends abstractValidator {

	public DiscoverCardValidator(abstractValidator nextValidator) {
		super(nextValidator);
	}

	@Override
	protected String getCardType(String cardNo) {
		if (cardNo != null && cardNo.length() == 16 && cardNo.startsWith("6011")) {
			return Constants._DISCOVER;
		} else if (nextValidator != null) {
			return nextValidator.getCardType(cardNo);
		}

		return Constants._INVALID;
	}

}
