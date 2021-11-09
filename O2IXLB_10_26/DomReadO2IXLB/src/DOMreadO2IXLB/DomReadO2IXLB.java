package DOMreadO2IXLB;

import javax.xml.parsers.DocumentBuilderFactory;  
import javax.xml.parsers.DocumentBuilder;  
import org.w3c.dom.Document;  
import org.w3c.dom.NodeList;  
import org.w3c.dom.Node;  
import org.w3c.dom.Element;  
import java.io.File;  

	public class DomReadO2IXLB{
		
		public static void main(String argv[]){  
			try{  
				//creating a constructor of file class and parsing an XML file  
				File file = new File("D:\\UniversityOfMiskolc\\University\\2021_22_1\\XML\\O2IXLB_10_26\\usersO2IXLB.xml");  
				
				//an instance of factory that gives a document builder  
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  

				//an instance of builder to parse the specified xml file  
				DocumentBuilder db = dbf.newDocumentBuilder();  
				Document doc = db.parse(file);  
				doc.getDocumentElement().normalize();  
				System.out.println("Root element: " + doc.getDocumentElement().getNodeName());  
				NodeList nodeList = doc.getElementsByTagName("user");  
				// nodeList is not iterable, so we are using for loop  
				for (int itr = 0; itr < nodeList.getLength(); itr++){
					
					Node node = nodeList.item(itr);  
					System.out.println("\nCurrent element :" + node.getNodeName());  
						if (node.getNodeType() == Node.ELEMENT_NODE){  
							Element eElement = (Element) node;  
								System.out.println("User id: "+ eElement.getElementsByTagName("id").item(0).getTextContent());  
								System.out.println("First Name: "+ eElement.getElementsByTagName("firstname").item(0).getTextContent());  
								System.out.println("Last Name: "+ eElement.getElementsByTagName("lastname").item(0).getTextContent());  
								System.out.println("Professional: "+ eElement.getElementsByTagName("Proffessional").item(0).getTextContent());  
								
						}  
				}  
			}catch (Exception e){  
				e.printStackTrace();  
			}  
		}  
	}  