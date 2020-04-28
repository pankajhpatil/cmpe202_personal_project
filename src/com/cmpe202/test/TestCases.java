/**
 * 
 */
package com.cmpe202.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.cmpe202.ip1.Main;

/**
 * @author pankaj
 *
 */
class TestCases {
public static final String _MESSAGE="Success";
	@Test
	void testXMLfileProcessing() {
		String filePath=System.getProperty("user.dir")+"/target/TestingFiles/xmlSample.xml";
		String outputFilePath= filePath.substring(0,filePath.lastIndexOf('/'))+"/Output."+Main.getFiletype(filePath);
	      assertEquals(_MESSAGE,Main.validateCards(filePath, outputFilePath));

	}
	@Test
	void testJONfileProcessing() {
		String filePath=System.getProperty("user.dir")+"/target/TestingFiles/jsonSample.json";
		String outputFilePath= filePath.substring(0,filePath.lastIndexOf('/'))+"/Output."+Main.getFiletype(filePath);
	      assertEquals(_MESSAGE,Main.validateCards(filePath, outputFilePath));

	}
	@Test
	void testCSVfileProcessing() {
		String filePath=System.getProperty("user.dir")+"/target/TestingFiles/csvSample.csv";
		String outputFilePath= filePath.substring(0,filePath.lastIndexOf('/'))+"/Output."+Main.getFiletype(filePath);
	      assertEquals(_MESSAGE,Main.validateCards(filePath, outputFilePath));

	}
	
	
	@Test
	void filePathvalidator() {
		String filePath=System.getProperty("user.dir")+"/target/TestingFiles/csvSample.csv";
		String outputFilePath= filePath.substring(0,filePath.lastIndexOf('/'))+"/Output."+Main.getFiletype(filePath);
	      assertEquals(true,Main.validateFilePaths(filePath, outputFilePath));

	}
	
	@Test
	void invalidfilePathvalidator() {
		String filePath=System.getProperty("user.dir")+"/target1/TestingFiles/csvSample.csv";
		String outputFilePath= filePath.substring(0,filePath.lastIndexOf('/'))+"/Output."+Main.getFiletype(filePath);
	      assertEquals(false,Main.validateFilePaths(filePath, outputFilePath));

	}


}
