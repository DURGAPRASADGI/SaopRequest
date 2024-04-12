package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

@Controller
public class SoapController {

    @PostMapping("/soap/addfffffffffffffffffffff")
    @ResponseBody
    public Map<String, Integer> addNumbers(@RequestBody String soapRequest) {
        Map<String, Integer> response = new HashMap<>();

        try {
            // Parse the SOAP request XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            org.w3c.dom.Document doc = builder.parse(new InputSource(new StringReader(soapRequest)));

            // Find the 'a' and 'b' elements using their tags
            NodeList aList = doc.getElementsByTagName("a");
            NodeList bList = doc.getElementsByTagName("b");

            // Ensure there's exactly one 'a' and 'b' element in the SOAP request
            if (aList.getLength() != 1 || bList.getLength() != 1) {
                throw new IllegalArgumentException("Invalid SOAP request. Expected one 'a' and one 'b' element.");
            }

            // Get the values of 'a' and 'b' and parse them to integers
            int a = Integer.parseInt(aList.item(0).getTextContent());
            int b = Integer.parseInt(bList.item(0).getTextContent());

            // Add the numbers
            int result = a + b;

            // Prepare the SOAP response
            response.put("result", result);
        } catch (NumberFormatException e) {
            // Handle if the input string cannot be parsed as an integer
            response.put("error", -1);
        } catch (IllegalArgumentException e) {
            // Handle if SOAP request is invalid
            response.put("error", -2);
        } catch (Exception e) {
            // Handle other exceptions
            e.printStackTrace();
            response.put("error", -3);
        }

        return response;
    }
}


