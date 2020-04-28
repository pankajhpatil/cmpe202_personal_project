package com.cmpe202.ip1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

	// we will use this list to hold the CC records
	private static List<CreditCard> ccInfo = new ArrayList<CreditCard>();
	private static ChainOfValidators vald = new ChainOfValidators();
	private static FileParserFactory fp = new FileParserFactory();
	private static CreditCardFactory ccf = new CreditCardFactory();
	private static String filetype;
	private static String filePath;
	private static String cardType;
	private static InputFileParser ifp = null;
	private static CreditCardIssuer cci = null;

	public static List<CreditCard> getCcInfo() {
		return ccInfo;
	}

	public static void setCcInfo(List<CreditCard> ccInfo) {
		Main.ccInfo = ccInfo;
	}

	public static ChainOfValidators getVald() {
		return vald;
	}

	public static void setVald(ChainOfValidators vald) {
		Main.vald = vald;
	}

	public static FileParserFactory getFp() {
		return fp;
	}

	public static void setFp(FileParserFactory fp) {
		Main.fp = fp;
	}

	public static CreditCardFactory getCcf() {
		return ccf;
	}

	public static void setCcf(CreditCardFactory ccf) {
		Main.ccf = ccf;
	}

	public static String getFiletype() {
		return filetype;
	}

	public static void setFiletype(String filetype) {
		Main.filetype = filetype;
	}

	public static String getFilePath() {
		return filePath;
	}

	public static void setFilePath(String filePath) {
		Main.filePath = filePath;
	}

	public static String getCardType() {
		return cardType;
	}

	public static void setCardType(String cardType) {
		Main.cardType = cardType!=null ? cardType.trim():"";
	}

	public static CreditCardIssuer getCci() {
		return cci;
	}

	public static void setCci(CreditCardIssuer cci) {
		Main.cci = cci;
	}

	public static InputFileParser getIfp() {
		return ifp;
	}

	public static void setIfp(InputFileParser ifp) {
		Main.ifp = ifp;
	}

	public static String validateCards(String filePath,String outputFilePath) {
		String message="Success";
		try {
					
		setFilePath(filePath);
		setFiletype(getFiletype(filePath));
		//If OutputFilePathIsNotGiven
		if(outputFilePath == null || "".equals(outputFilePath)) {
			outputFilePath=(getFilePath().substring(0,getFilePath().lastIndexOf('/'))+"/Output."+getFiletype(getFilePath()));
		}
		setIfp(fp.getFileParser(getFiletype()));
		//parse file and get list of records
		if(getIfp()!=null) {
		setCcInfo(getIfp().parseFile(filePath));
		}else{
			System.out.println("Invalid File Type :"+filePath);
		}
		//get type of card
		if(getCcInfo()!=null) {
		for (CreditCard cc : getCcInfo()) {

			// Calling chain of responsibility
			
			
			setCardType(vald.getCardType(cc.getCreditCardNo()));

			//System.out.print(cc.getCreditCardNo() + "\t\t\t" + getCardType() + "\t\t\t");
			setCci(ccf.getCCIssuer(getCardType()));
			
			cc.setCardType(cardType);
			
			
			// cci.getCreditCardIssuer();
			if (getCci() == null || "Invalid".equalsIgnoreCase(getCardType())) {
				cc.setError(Constants._INVALID_CARD);
			}
			
		}
		}else {
			message="Invalid File";
		}
		message=getIfp().createOutputFile(outputFilePath, getCcInfo());
		}catch(Exception e) {
			e.printStackTrace();
			return "Error";
		}
		return message;
	}
	
	public static boolean validateFilePaths(String ipFile,String opFile) {
		boolean exists =false;
		try{
		File ip;
		try
	      {
	    	ip = new File(ipFile); 
	        exists = ip.exists();
	      } catch (Exception e)
	      {
	    	  System.out.println("File not present at given path "+ipFile);
	    	  System.out.println("Error Is :  "+e.getMessage());
	    	  return false;
	      }
		File op;	
		try
	      {
	    	op = new File(opFile.substring(0,opFile.lastIndexOf('/'))); 
	        exists = op.isDirectory();
	      } catch (Exception e)
	      {
	    	  System.out.println("Output File Directory not present "+ipFile);
	    	  System.out.println("Error Is :  "+e.getMessage());
	    	  return false;
	      } 
		
		
	        
	        if(exists) {
	        if(!getFiletype(ipFile).equals(getFiletype(opFile))) {
	        System.out.println("Input file and Output file type Mismatch");	
	        return false;
	        }
	        }
		} catch (Exception e)
	      {
	    	  System.out.println("Error Occured while accessing Files "+ipFile);
	    	  System.out.println("Error Is :  "+e.getMessage());
	    	  return false;
	      }     
	        
	   return exists;  
	}
	
	
	public static void main(String[] args) {
		if(args.length>0 && args[0]!=null && !"".equals(args[0])) {
		System.out.println(args[0]+args[1]);	
		String ipFile=args[0];
		String opFile=args[1];
		
	      try
	      {if(validateFilePaths(ipFile,opFile)) {  
	        System.out.println("Processing File "+ipFile);
	        System.out.println("Processing Complete with status : "+validateCards(ipFile,opFile));
	        }
	      } catch (Exception e)
	      {
	    	  
	    	  System.out.println("Error occured while processing the file :  "+e.getMessage());
	      }
		}else {
			System.out.println("Please provide filePath via system args");
		}
		
		
	}

	// get fileExtension to resolve file type
	public static String getFiletype(String fileName){
		String extension = "";
		int i = fileName.lastIndexOf('.');
		if (i > 0) {
			extension = fileName.substring(i + 1);
		}
		return extension;
	}

}
