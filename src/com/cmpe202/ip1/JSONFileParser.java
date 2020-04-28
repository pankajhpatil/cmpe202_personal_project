package com.cmpe202.ip1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

import org.json.*;

public class JSONFileParser implements InputFileParser {

	public List<CreditCard> parseFile(String filepath) {
	List<CreditCard> cclist = new ArrayList<CreditCard>();

		String str="";
		try {
			str = new String ( Files.readAllBytes( Paths.get(filepath)));
		} catch (IOException e1) {
			e1.printStackTrace();
			return null;
		}
		JSONArray arr = new JSONArray(str);
		for (int i = 0; i < arr.length(); i++) {
		CreditCard item = new CreditCard();
		JSONObject iObj=new JSONObject(arr.get(i).toString());
		try {
		item.setCreditCardNo(String.valueOf(iObj.getLong("CardNumber")));
		} catch (Exception e) {
			item.setCreditCardNo(null);
			System.out.println("Invalid cardNo "+e.getMessage());

		}
		try {
			item.setExpirationDate(new SimpleDateFormat("M/dd/yyyy").parse(iObj.getString("ExpirationDate")));
		} catch (Exception e) {
			item.setExpirationDate(null);
			System.out.println("Invalid date "+e.getMessage());

		}
		
		try {
			item.setCardHolderName(iObj.getString("NameOfCardholder"));
			} catch (Exception e) {
				item.setCreditCardNo(null);
				System.out.println("Invalid CardHolder Name "+e.getMessage());

			}
		cclist.add(item);
		}

		return cclist;
	}

	@Override
	public String createOutputFile(String filePath, List<CreditCard> ccList) {
		String message="Success";
		try {
			FileWriter writer = new FileWriter(filePath);
	        JSONArray ja = new JSONArray();
	       
			
		    for(CreditCard cc:ccList) {
		    			 
				JSONObject jo = new JSONObject();
					
					jo.put("CardNumber", Pattern.matches("[0-9]*", cc.getCreditCardNo())?Long.parseLong(cc.getCreditCardNo()):0);
					jo.put("CardType", cc.getCardType());
					jo.put("Error", cc.getError()); 
					ja.put(jo);
		    	}
		    
	    	writer.write(ja.toString(1));
		    writer.close();	
			}catch(IOException i) {
				i.printStackTrace();
				message=i.getMessage();
			}
		
		    return message;
		
	}

}
