package com.cmpe202.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import com.cmpe202.ip1.CSVFileParser;
import com.cmpe202.ip1.Constants;
import com.cmpe202.ip1.CreditCard;
import com.cmpe202.ip1.JSONFileParser;
import com.cmpe202.ip1.Main;
import com.cmpe202.ip1.XMLFileParser;

class FileparserTest {

	@Test
	void testXMLfileProcessing() throws IOException, ParseException, ParserConfigurationException, SAXException {
		String filePath=System.getProperty("user.dir")+"/target/TestingFiles/xmlSample_1.xml";
		XMLFileParser cfp=new XMLFileParser();
		CreditCard c = new CreditCard();
		c.setCreditCardNo("5410000000000000");
		c.setCardHolderName("Alice");
		c.setExpirationDate(new SimpleDateFormat("M/dd/yyyy").parse("3/20/2030"));
		List<CreditCard> op=new ArrayList<CreditCard>();
		op.add(c);

	      assertEquals(op.get(0).getCreditCardNo(),cfp.parseFile(filePath).get(0).getCreditCardNo());
	      assertEquals(op.get(0).getCardHolderName(),cfp.parseFile(filePath).get(0).getCardHolderName());
	      assertEquals(op.get(0).getExpirationDate(),cfp.parseFile(filePath).get(0).getExpirationDate());

			

	}
	@Test
	void testJONfileProcessing() throws IOException, ParseException  {
		String filePath=System.getProperty("user.dir")+"/target/TestingFiles/jsonSample_1.json";
		JSONFileParser cfp=new JSONFileParser();
		CreditCard c = new CreditCard();
		c.setCreditCardNo("5410000000000000");
		c.setCardHolderName("Alice");
		c.setExpirationDate(new SimpleDateFormat("M/dd/yyyy").parse("3/20/2030"));
		List<CreditCard> op=new ArrayList<CreditCard>();
		op.add(c);

	      assertEquals(op.get(0).getCreditCardNo(),cfp.parseFile(filePath).get(0).getCreditCardNo());
	      assertEquals(op.get(0).getCardHolderName(),cfp.parseFile(filePath).get(0).getCardHolderName());
	      assertEquals(op.get(0).getExpirationDate(),cfp.parseFile(filePath).get(0).getExpirationDate());


	}
	@Test
	void testCSVfileProcessing() throws IOException, ParseException {
		String filePath=System.getProperty("user.dir")+"/target/TestingFiles/csvSample_1.csv";
		CSVFileParser cfp=new CSVFileParser();
		CreditCard c = new CreditCard();
		c.setCreditCardNo("5410000000000000");
		c.setCardHolderName("Alice");
		c.setExpirationDate(new SimpleDateFormat("M/dd/yyyy").parse("3/20/2030"));
		List<CreditCard> op=new ArrayList<CreditCard>();
		op.add(c);

	      assertEquals(op.get(0).getCreditCardNo(),cfp.parseFile(filePath).get(0).getCreditCardNo());
	      assertEquals(op.get(0).getCardHolderName(),cfp.parseFile(filePath).get(0).getCardHolderName());
	      assertEquals(op.get(0).getExpirationDate(),cfp.parseFile(filePath).get(0).getExpirationDate());

	}

}
