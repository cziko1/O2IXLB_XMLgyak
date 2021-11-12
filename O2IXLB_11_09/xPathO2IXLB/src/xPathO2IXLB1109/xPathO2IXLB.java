package xPathO2IXLB1109;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.*;

import jdk.internal.org.xml.sax.SAXException;


public class xPathO2IXLB {
	
	public static void main(String agrs[]) {
		
		try {
			//creating a constructor of file class and parsing an XML file  
			File file = new File("D:\\UniversityOfMiskolc\\University\\2021_22_1\\XML\\O2IXLB_11_09\\studentO2IXLB.xml");  
			
			//an instance of factory that gives a document builder  
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  

			//an instance of builder to parse the specified xml file  
			DocumentBuilder db = dbf.newDocumentBuilder();  
			Document doc = db.parse(file);  
			doc.getDocumentElement().normalize(); 
		
			//az xPath keszitese
			
			XPath xPath = XPathFactory.newInstance().newXPath();

			String expression = "/class/student";
			NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);
			
			for (int itr = 0; itr < nodeList.getLength(); itr++){
				
				Node node = nodeList.item(itr);  
				System.out.println("\nStudent :" + node.getNodeName());  
					if (node.getNodeType() == Node.ELEMENT_NODE){  
						Element eElement = (Element) node;  
							System.out.println("Student id: "+ eElement.getElementsByTagName("id").item(0).getTextContent());  
							System.out.println("First Name: "+ eElement.getElementsByTagName("firstname").item(0).getTextContent());  
							System.out.println("Last Name: "+ eElement.getElementsByTagName("lastname").item(0).getTextContent());  
							System.out.println("Age: "+ eElement.getElementsByTagName("age").item(0).getTextContent());  
					}  
			}  
			
		  } catch (ParserConfigurationException e) {
		         e.printStackTrace();
		  } catch (SAXException e) {
		         e.printStackTrace();
		  } catch (IOException e) {
		         e.printStackTrace();
		  } catch (XPathExpressionException e) {
		         e.printStackTrace();
		  }
		
		
	}
		public static void writeToConsole(String expression) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		File inputFile = new File("D:\\UniversityOfMiskolc\\University\\Java\\xPathO2IXLB\\studentO2IXLB.xml");
        DocumentBuilderFactory pieceOfFact = DocumentBuilderFactory.newInstance();
        DocumentBuilder DocBuilder;
        DocBuilder = pieceOfFact.newDocumentBuilder();
		Document doc = DocBuilder.parse(inputFile);
	    doc.getDocumentElement().normalize();
		XPath xPath =  XPathFactory.newInstance().newXPath();
		NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(doc,XPathConstants.NODESET);
		for (int i = 0; i < nodeList.getLength(); i++) {
    		Node NoDe = nodeList.item(i);
    		System.out.println("\nCurrent Element :" + NoDe.getNodeName());

    		if (NoDe.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) NoDe;
                System.out.println("Student id :" + element.getAttribute("id"));
                System.out.println("First Name : " + element.getElementsByTagName("firstname").item(0).getTextContent());
                System.out.println("Last Name : " + element.getElementsByTagName("lastname").item(0).getTextContent());
                System.out.println("Nick Name : " + element.getElementsByTagName("nickname").item(0).getTextContent());
                System.out.println("Age : " + element.getElementsByTagName("age").item(0).getTextContent());
             }
		}
	}
	public static void writeToConsole2(String expression) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		File inputFile = new File("studentO2IXLB.xml");
        DocumentBuilderFactory pieceOfFact = DocumentBuilderFactory.newInstance();
        DocumentBuilder DocBuilder;
        DocBuilder = pieceOfFact.newDocumentBuilder();
		Document doc = DocBuilder.parse(inputFile);
	    doc.getDocumentElement().normalize();
		XPath xPath =  XPathFactory.newInstance().newXPath();
		NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(doc,XPathConstants.NODESET);
		for (int i = 0; i < nodeList.getLength(); i++) {
    		Node NoDE = nodeList.item(i);
    		System.out.println("Current element:" + NoDE.getNodeName());
    		if (NoDE.getNodeType() == Node.ELEMENT_NODE && NoDE.getNodeName().equals("firstname")) {
                Element element = (Element) NoDE;
                System.out.println(element.getTextContent());
             }
    		else {
    			Element element = (Element) NoDE;
                System.out.println(element.getTextContent());
    		}

		}
	}

}
