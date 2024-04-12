package com.example.demo;

import java.io.StringWriter;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

@RestController
public class Own {
	
    @PostMapping("/soap/added")

	  public ResponseEntity<String> addNumbers(@RequestBody String soapRequest) throws TransformerException, ParserConfigurationException {
		System.out.println(soapRequest); 
		System.out.println("hii");
    	DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
          DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
          Document doc = docBuilder.newDocument();

          // Create root element
          Element rootElement = doc.createElement(soapRequest);
          doc.appendChild(rootElement);
       // Convert Document to XML String
          TransformerFactory transformerFactory = TransformerFactory.newInstance();
          Transformer transformer = transformerFactory.newTransformer();
          StringWriter writer = new StringWriter();
          transformer.transform(new DOMSource(doc), new StreamResult(writer));
          String xmlString = writer.getBuffer().toString();

          // Return the XML String
          return ResponseEntity.ok(xmlString);
	  }

}
