package com.cmpe202.ip1;

import java.util.List;

public interface InputFileParser {

	public List<CreditCard> parseFile(String filePath) throws Exception;
	public String createOutputFile(String filePath,List<CreditCard> ccList) ;
}
