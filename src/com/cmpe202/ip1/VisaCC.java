package com.cmpe202.ip1;

public class VisaCC implements CreditCardIssuer {

	public VisaCC() {
		System.out.println("VisaCC Class Instance Created");
	}

	@Override
	public void getCreditCardIssuer() {
		System.out.println("Inside VisaCC getCreditCardIssuer interface method implementaion");
	}

}
