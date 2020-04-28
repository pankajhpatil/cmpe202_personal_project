package com.cmpe202.ip1;

import java.io.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.text.SimpleDateFormat;
import java.util.*;

public class XMLFileParser implements InputFileParser {

	public List<CreditCard> parseFile(String filepath) throws ParserConfigurationException, SAXException, IOException {

		List<CreditCard> cclist = new ArrayList<CreditCard>();
			

				File fXmlFile = new File(filepath);
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(fXmlFile);
						
				//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
				doc.getDocumentElement().normalize();
						
				NodeList nList = doc.getElementsByTagName("row");
				

				for (int temp = 0; temp < nList.getLength(); temp++) {

					Node nNode = nList.item(temp);
					
							
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {

						Element eElement = (Element) nNode;
						
						CreditCard item = new CreditCard();
						
						item.setCreditCardNo(eElement.getElementsByTagName("CardNumber").item(0).getTextContent());
						try {
							item.setExpirationDate(new SimpleDateFormat("M/dd/yyyy").parse(eElement.getElementsByTagName("ExpirationDate").item(0).getTextContent()));
						} catch (Exception e) {
							item.setExpirationDate(null);
							System.out.println("Invalid date for cardNo :"+eElement.getElementsByTagName("CardNumber").item(0).getTextContent()+"(date :"+eElement.getElementsByTagName("ExpirationDate").item(0).getTextContent()+")  -"+e.getMessage());

						}
						item.setCardHolderName(eElement.getElementsByTagName("NameOfCardholder").item(0).getTextContent());
						cclist.add(item);

					}
				}
		return cclist;
	}

	@Override
	public String createOutputFile(String filePath, List<CreditCard> ccList) {
		String message="Success";

		
	    try {
		DocumentBuilderFactory icFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder icBuilder;
    	
        icBuilder = icFactory.newDocumentBuilder();
        Document doc = icBuilder.newDocument();
        doc.setXmlStandalone(true);

        Element mainRootElement = doc.createElement("root");
        doc.appendChild(mainRootElement);

        // append child elements to root element
        for(CreditCard cc:ccList) {
			 
            mainRootElement.appendChild(getElement(doc, cc.getCreditCardNo(), cc.getCardType(), cc.getError()));
	    	}
     
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        
        Transformer transformer = transformerFactory.newTransformer();
        
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, ""); 
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

        
        DOMSource domSource = new DOMSource(doc);
        StreamResult streamResult = new StreamResult(new File(filePath));

        transformer.transform(domSource, streamResult);

    } catch (Exception e) {
    	e.printStackTrace();
    	message=e.getMessage();
    }
    return message;

}
	private static Node getElement(Document doc, String cardNumber, String cardType, String error) {
        Element row = doc.createElement("row");
        row.appendChild(getRootElements(doc, row, "CardNumber", cardNumber));
        row.appendChild(getRootElements(doc, row, "CardType", cardType));
        row.appendChild(getRootElements(doc, row, "Error", error));
        return row;
    }
 
    // utility method to create text node
    private static Node getRootElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }	
}
