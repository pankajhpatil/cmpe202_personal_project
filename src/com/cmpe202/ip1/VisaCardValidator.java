package com.cmpe202.ip1;

public class VisaCardValidator extends abstractValidator {

	public VisaCardValidator(abstractValidator nextValidator) {
		super(nextValidator);
	}

	@Override
	protected String getCardType(String cardNo) {
		
		if (cardNo != null && (cardNo.length() == 16 || cardNo.length() == 13) && cardNo.startsWith("4")) {
			return Constants._VISA;
		} else if (nextValidator != null) {
			return nextValidator.getCardType(cardNo);
		}

		return Constants._INVALID;
	}

}
