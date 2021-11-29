package hu.domparse.o2ixlb;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMQueryO2IXLB {

	// Forras: https://www.tutorialspoint.com/java_xml/java_dom_query_document.htm

	public static void main(String argv[]) {

		try {
			File inputFile = new File(
					"D:\\UniversityOfMiskolc\\University\\2021_22_1\\XML\\O2IXLB_FelevesBeadando\\O2IXLBvonat.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			System.out.print("Root element: ");
			System.out.println(doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("vonat");
			NodeList mList = doc.getElementsByTagName("megallok");
			System.out.println("----------------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				System.out.println("\nCurrent Element :");
				System.out.print(nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					System.out.print(" ID : ");
					System.out.println(eElement.getAttribute("id"));
					NodeList vagonokszamaelement = eElement.getElementsByTagName("vagonokszama");

					for (int count = 0; count < vagonokszamaelement.getLength(); count++) {
						Node node1 = vagonokszamaelement.item(count);

						if (node1.getNodeType() == Node.ELEMENT_NODE) {
							Element vonatVagon = (Element) node1;
							System.out.print("Vagonok szama : ");
							System.out.println(vonatVagon.getTextContent());
							System.out.print(vonatVagon.getAttribute("type"));
						}
					}
				}
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					eElement.getAttribute("id");
					NodeList nodeElement = eElement.getElementsByTagName("keresztnev");

					for (int count = 0; count < nodeElement.getLength(); count++) {
						Node node1 = nodeElement.item(count);

						if (node1.getNodeType() == Node.ELEMENT_NODE) {
							Element keresztnevelement = (Element) node1;
							System.out.print("Mozdonyvezet :\n\tKeresztnev : ");
							System.out.println(keresztnevelement.getTextContent());
							System.out.print(keresztnevelement.getAttribute("type"));
						}
					}

				}
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					eElement.getAttribute("id");
					NodeList nodeElement = eElement.getElementsByTagName("vezeteknev");

					for (int count = 0; count < nodeElement.getLength(); count++) {
						Node node1 = nodeElement.item(count);

						if (node1.getNodeType() == Node.ELEMENT_NODE) {
							Element vezetekenevelement = (Element) node1;
							System.out.print("\tVezeteknev : ");
							System.out.println(vezetekenevelement.getTextContent());
							System.out.print(vezetekenevelement.getAttribute("type"));
						}

					}
				}

			}
			System.out.println("\n----------------------------");

			for (int temp = 0; temp < mList.getLength(); temp++) {
				Node nNode = mList.item(temp);
				System.out.println("\nCurrent Element :");
				System.out.print(nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					System.out.print(" ID : ");
					System.out.println(eElement.getAttribute("id"));
					NodeList iranyoszanelement = eElement.getElementsByTagName("iranyitoszam");

					for (int count = 0; count < iranyoszanelement.getLength(); count++) {
						Node node1 = iranyoszanelement.item(count);

						if (node1.getNodeType() == node1.ELEMENT_NODE) {
							Element iranyitoszamelement = (Element) node1;
							System.out.print("Iranyitoszam : ");
							System.out.println(iranyitoszamelement.getTextContent());
							System.out.print(iranyitoszamelement.getAttribute("type"));
						}
					}

				}
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					eElement.getAttribute("id");
					NodeList nodeElement = eElement.getElementsByTagName("hazszam");

					for (int count = 0; count < nodeElement.getLength(); count++) {
						Node node1 = nodeElement.item(count);

						if (node1.getNodeType() == Node.ELEMENT_NODE) {
							Element hazszamelement = (Element) node1;
							System.out.print("Hazszam : ");
							System.out.println(hazszamelement.getTextContent());
							System.out.print(hazszamelement.getAttribute("type"));
						}

					}
				}
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					eElement.getAttribute("id");
					NodeList nodeElement = eElement.getElementsByTagName("utca");

					for (int count = 0; count < nodeElement.getLength(); count++) {
						Node node1 = nodeElement.item(count);

						if (node1.getNodeType() == Node.ELEMENT_NODE) {
							Element utcaelement = (Element) node1;
							System.out.print("Utca : ");
							System.out.println(utcaelement.getTextContent());
							System.out.print(utcaelement.getAttribute("type"));
						}

					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
