package hu.domparse.o2ixlb;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.traversal.DocumentTraversal;
import org.w3c.dom.traversal.NodeFilter;
import org.w3c.dom.traversal.TreeWalker;
import org.xml.sax.SAXException;

public class DOMTreeO2IXLB {

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder loader = factory.newDocumentBuilder();
		Document document = loader
				.parse("D:\\UniversityOfMiskolc\\University\\2021_22_1\\XML\\O2IXLB_FelevesBeadando\\O2IXLBvonat.xml");

		DocumentTraversal traversal = (DocumentTraversal) document;

		TreeWalker walker = traversal.createTreeWalker(document.getDocumentElement(),
				NodeFilter.SHOW_ELEMENT | NodeFilter.SHOW_TEXT, null, true);

		traverseLevel(walker, "");
	}

	private static void traverseLevel(TreeWalker walker, String indent) {

		Node node = walker.getCurrentNode();

		if (node.getNodeType() == Node.ELEMENT_NODE) {
			System.out.println(indent + node.getNodeName());
		}

		if (node.getNodeType() == Node.TEXT_NODE) {

			String content_trimmed = node.getTextContent().trim();

			if (content_trimmed.length() > 0) {
				System.out.print(indent);
				System.out.printf("%s%n", content_trimmed);
			}
		}

		for (Node n = walker.firstChild(); n != null; n = walker.nextSibling()) {

			traverseLevel(walker, indent + "  ");
		}

		walker.setCurrentNode(node);
	}
}