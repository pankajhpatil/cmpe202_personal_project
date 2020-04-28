package com.cmpe202.ip1;

public class ChainOfValidators {

	abstractValidator chain;

	public ChainOfValidators() {
		buildChain();
	}

	private void buildChain() {
		chain = new GenericValidator(new VisaCardValidator(new MasterCardValidator(new AmExCardValidator(new DiscoverCardValidator(null)))));
	}

	public String getCardType(String cardNo) {
		return chain.getCardType(cardNo);
	}
}
