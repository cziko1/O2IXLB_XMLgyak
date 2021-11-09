package O2IXLB1026;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class DomWriteO2IXLB {
	
	public static void main(String[] args) throws ParserConfigurationException,
    
	TransformerException {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.newDocument();
		
			Element root = doc.createElementNS("D:\\UniversityOfMiskolc\\University\\2021_22_1\\XML\\O2IXLB_10_26", "usersO2IXLB");
			doc.appendChild(root);
		
			root.appendChild(createUser(doc, "101", "Tivadar", "Cziko", "programmer"));
			root.appendChild(createUser(doc, "102", "Johnatan", "Superbusson", "Technical Manager"));
			root.appendChild(createUser(doc, "103", "Moses", "Swarowsky", "Technical Engineer"));
		
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transf = transformerFactory.newTransformer();
		
			transf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transf.setOutputProperty(OutputKeys.INDENT, "yes");
			transf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		
			DOMSource source = new DOMSource(doc);
		
			File myFile = new File("usersO2IXLB.xml");
		
			StreamResult console = new StreamResult(System.out);
			StreamResult file = new StreamResult(myFile);
			
			transf.transform(source, console);
			transf.transform(source, file);
		}
	
		private static Node createUser(Document doc, String id, String firstName, 
				
			String lastName, String proffesion) {
	
				Element user = doc.createElement("user");
	
				user.setAttribute("id", id);
				user.appendChild(createUserElement(doc, "firstname", firstName));
				user.appendChild(createUserElement(doc, "lastname", lastName));
				user.appendChild(createUserElement(doc, "proffesional", proffesion));
				
				return user;
			}
	
			private static Node createUserElement(Document doc, String name, 
	   
		String value) {
	
			Element node = doc.createElement(name);
			node.appendChild(doc.createTextNode(value));
				
		return node;
		}

}
