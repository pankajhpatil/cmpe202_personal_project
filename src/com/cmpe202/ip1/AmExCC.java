package com.cmpe202.ip1;

public class AmExCC implements CreditCardIssuer {

	public AmExCC() {
		System.out.println("AmEx Class Instance Created");
	}

	@Override
	public void getCreditCardIssuer() {
		System.out.println("Inside AMEX getCreditCardIssuer interface method implementaion");
	}

}
