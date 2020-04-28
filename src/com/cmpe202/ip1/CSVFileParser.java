package com.cmpe202.ip1;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.*;
import java.util.stream.Collectors;
import java.util.function.Function;

public class CSVFileParser implements InputFileParser {

	private Function<String, CreditCard> mapToItem = (line) -> {
		// a CSV has comma separated lines
		String[] p = line.split(",");
		CreditCard item = new CreditCard();
//		System.out.println(p[0]);
		if(p.length>2) {
		item.setCreditCardNo(p[0]);
		try {
			item.setExpirationDate(new SimpleDateFormat("M/dd/yyyy").parse(p[1]));
		} catch (ParseException e) {
			item.setExpirationDate(null);
			System.out.println("Invalid date for cardNo :"+p[0]+"(date :"+p[1]+")  -"+e.getMessage());
		}
		item.setCardHolderName(p[2]);
		}
		// more initialization goes here
		return item;
	};

	public List<CreditCard> parseFile(String filepath) throws IOException {

		List<CreditCard> cclist = new ArrayList<CreditCard>();
		
			File inputF = new File(filepath);
			InputStream inputFS = new FileInputStream(inputF);
			BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
			// skip the header of the csv
			cclist = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());
			br.close();
		return cclist;
	}

	@Override
	public String createOutputFile(String filePath, List<CreditCard> ccList) {
		String message="Success";
		try {
		FileWriter writer = new FileWriter(filePath);
	    StringBuilder sb=new StringBuilder();
	    
    	writer.write("CardNumber,CardType,Error");
        writer.write("\n");
    	
	    for(CreditCard cc:ccList) {
	    	sb=new StringBuilder();
	    	sb.append(cc.getCreditCardNo()).append(",").append(cc.getCardType()).append(",").append(cc.getError());
	    	writer.write(sb.toString());
	    	writer.write("\n");
	    	}
	    	writer.close();	
		}catch(IOException i) {
			System.out.println(i);
			message=i.getMessage();
		}
	
	    return message;
	}

}
