package com.cmpe202.ip1;

//Implemented Factory design to get the appropriate CC class
public class CreditCardFactory {
	private CreditCardIssuer cci = null;

	public CreditCardIssuer getCci() {
		return cci;
	}

	public void setCci(CreditCardIssuer cci) {
		this.cci = cci;
	}

	public CreditCardIssuer getCCIssuer(String CCIssuer) {
		if (CCIssuer == null) {
			return null;
		}

		if ("Visa".equalsIgnoreCase(CCIssuer)) {
			setCci(new VisaCC());

		} else if ("MasterCard".equalsIgnoreCase(CCIssuer)) {
			setCci(new MasterCC());

		} else if ("AmericanExpress".equalsIgnoreCase(CCIssuer)) {
			setCci(new AmExCC());
		} else if ("Discover".equalsIgnoreCase(CCIssuer)) {
			setCci(new DiscoverCC());
		}

		return getCci();
	}

}
