package com.cmpe202.ip1;

public class MasterCC implements CreditCardIssuer {

	public MasterCC() {
		System.out.println("MasterCC Class Instance Created");

	}

	@Override
	public void getCreditCardIssuer() {
		System.out.println("Inside MasterCC getCreditCardIssuer interface method implementaion");
	}

}
