package com.nc.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomParser {

	public DomParser() {
	}

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		//Create object of DocumentBuilderFactory - to get the builder through it.
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		
		//Create object of DocumentBuilder using DocumentBuilderFactory - to get the Document object for XML
		DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
		
		//Create object of Document by parsing the input XML - to be able to obtain the NodeList for traversal.
		Document document = builder.parse("d://Workspaces//NTT-Docomo//RnD-NC//src//com//nc//parser//employees.xml");
		//ClassLoader.getSystemResourceAsStream("employees.xml")
		
		//Create object of NodeList from the Document object - to be able to identify individual nodes (items)
		NodeList nodeList = document.getChildNodes();
		
		List<Employee> empList = new ArrayList<Employee>();

		//Looping over nodeList
		for(int i=0;i<nodeList.getLength();i++)
		{
			//Picking up a node/item from the list
			Node node = nodeList.item(i);
			
			if(node instanceof Element)
			{
				
				//emp.id = node.getAttributes().getNamedItem("id").getNodeValue();
				
				NodeList internalNodeList = node.getChildNodes();
				
				for(int j=0; j < internalNodeList.getLength(); j++)
				{
					Employee emp = new Employee();
					
					Node iNode = internalNodeList.item(j);
					
					if(iNode instanceof Element)
					{
						String iNodeText = iNode.getLastChild().getTextContent().trim();
						
						switch(iNodeText)
						{
						case "firstName":
							emp.firstName = iNodeText;
							break;
						case "lastName":
							emp.lastName = iNodeText;
							break;
						case "location":
							emp.location = iNodeText;
							break;
						}
					}
					
					empList.add(emp);
							
				}
				
				
			}
		}
		
		for(Employee emp : empList)
		{
			System.out.println(emp);
		}
	}

}
