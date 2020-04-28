/**
 * 
 */
package com.cmpe202.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.cmpe202.ip1.ChainOfValidators;
import com.cmpe202.ip1.Constants;

/**
 * @author pankaj
 *
 */
class ValidatorTest {
public static final String _MESSAGE="Success";
private static ChainOfValidators vald = new ChainOfValidators();
	@Test
	void masterCardValidator() {
		String cardNo="5410000000000000";
	      assertEquals(Constants._MASTERCARD, vald.getCardType(cardNo));
	      
	}
	@Test
	void visaValidator() {
		String cardNo="4120000000000";
	      assertEquals(Constants._VISA, vald.getCardType(cardNo));
	      
	}
	@Test
	void AmericanExpressValidator() {
		String cardNo="341000000000000";
	      assertEquals(Constants._AMEX, vald.getCardType(cardNo));
	      
	}
	
	@Test
	void discoverValidator() {
		String cardNo="6011000000000000";
	      assertEquals(Constants._DISCOVER, vald.getCardType(cardNo));
	      
	}
	
	@Test
	void invalidCardNoValidator() {
		String cardNo="";
		assertEquals(Constants._INVALID, vald.getCardType(cardNo));
	      
	}

}
