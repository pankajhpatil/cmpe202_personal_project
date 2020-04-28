package com.cmpe202.ip1;

public class DiscoverCC implements CreditCardIssuer {

	public DiscoverCC() {
		System.out.println("DiscoverCC Class Instance Created");
	}

	@Override
	public void getCreditCardIssuer() {
		System.out.println("Inside DiscoverCC getCreditCardIssuer interface method implementaion");
	}

}
