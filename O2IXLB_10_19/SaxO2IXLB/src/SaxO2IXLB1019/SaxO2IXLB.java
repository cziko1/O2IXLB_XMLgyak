package SaxO2IXLB1019;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;
public class SaxO2IXLB{
	public static void main(String[] args) {
	      boolean result = validateXMLSchema("szemelyeO2IXLB.xsd", "szemelyekO2IXLB.xml");
	      if(result) {
	    	  System.out.println("A validalas sikeres!");
	      }else {
	    	  System.out.println("A validálása sikertelen!");
	      }
	   }

	    public static boolean validateXMLSchema(String xsdPath, String xmlPath){

	        try {
	            SchemaFactory fact = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
	            Schema sch = fact.newSchema(new File(xsdPath));
	            Validator val = sch.newValidator();
	            val.validate(new StreamSource(new File(xmlPath)));
	        } catch (IOException | SAXException e) {
	            System.out.println("Exception: "+e.getMessage());
	            return false;
	        }
	        return true;
	    }
}
