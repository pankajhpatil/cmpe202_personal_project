package com.cmpe202.ip1;
import java.util.Date;

public class CreditCard {
	private String creditCardNo;
	private Date expirationDate;
	private String cardHolderName;
	private String cardType;
	public String getCardType() {
		return (cardType!= null ? cardType:"Invalid");
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getError() {
		return error == null ? "None": error;
	}

	public void setError(String error) {
		this.error = error;
	}

	private String error;

	public String getCreditCardNo() {
		return (creditCardNo!= null ? creditCardNo:"0");
	}

	public void setCreditCardNo(String creditCardNo) {
		this.creditCardNo = creditCardNo;
	}

	@SuppressWarnings("deprecation")
	public Date getExpirationDate() {
		return (expirationDate!=null ? expirationDate: new Date("01/01/1111"));
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getCardHolderName() {
		return (cardHolderName!= null ? cardHolderName:"");
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

}
