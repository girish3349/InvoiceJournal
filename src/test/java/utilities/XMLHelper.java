package utilities;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLHelper {

	File file;
	DocumentBuilderFactory dbf;
	DocumentBuilder db;
	Document doc;
	NodeList rowNode;
	Element element;

	public XMLHelper(String filename) {

		file = new File(System.getProperty("user.dir") + "\\Data\\" + filename);

		// Defines a factory API that enables applications to obtain a parser that
		// produces DOM object trees from XML documents.
		dbf = DocumentBuilderFactory.newInstance();

		// we are creating an object of builder to parse the xml file.
		try {
			db = dbf.newDocumentBuilder();

			doc = db.parse(file);
		} catch (SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (

		ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doc.getDocumentElement().normalize();
		// Here nodeList contains all the nodes with name row.
		rowNode = doc.getElementsByTagName("row");

	}

	public void getuserData() {

		for (int i = 0; i < rowNode.getLength(); ++i) {
			System.out.println("@@@@@@@@@@@@");
			// String userNode = rowNode.item(i).getNodeName();
			Node userNode = rowNode.item(i);

			if (userNode.getNodeType() == Node.ELEMENT_NODE) {
				System.out.println("\n Outer Node Name :" + userNode.getNodeName());
				Node node = userNode;
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					element = (Element) node;
					System.out.println("UserName: " + getElemntData("username"));
					System.out.println("password: " + getElemntData("password"));
					
					System.out.println("Product Name: " + getElemntData("name"));
					System.out.println("Price: " + getElemntData("price"));
				}
			}

			

		}
	}

	public void getProductData() {

		for (int i = 0; i < rowNode.getLength(); ++i) {
			NodeList productNode = doc.getElementsByTagName("product");
			if (productNode.item(i) != null) {
				System.out.println("\n Outer Node Name :" + productNode.item(i).getNodeName());
				Node node = productNode.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					element = (Element) node;
					System.out.println("Product Name: " + getElemntData("name"));
					System.out.println("Price: " + getElemntData("price"));

				}
			}
		}
	}

	public String getElemntData(String tagname) {

		return (element.getElementsByTagName(tagname).item(0).getTextContent());

	}

}
