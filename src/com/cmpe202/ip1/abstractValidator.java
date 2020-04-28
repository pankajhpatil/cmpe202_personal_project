package com.cmpe202.ip1;

public abstract class abstractValidator {

	// next element in chain or responsibility
	protected abstractValidator nextValidator;

	public abstractValidator(abstractValidator nextValidator) {
		this.nextValidator = nextValidator;
	}

	abstract protected String getCardType(String cardN);

}
