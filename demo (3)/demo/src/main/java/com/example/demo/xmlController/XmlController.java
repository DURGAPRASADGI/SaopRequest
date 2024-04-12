package com.example.demo.xmlController;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.AddRequest;


@RestController
public class XmlController {
	
	@PostMapping(path = "/herd", produces = MediaType.APPLICATION_XML_VALUE, consumes =   MediaType.APPLICATION_XML_VALUE)

	void saveHerd(@RequestBody AddRequest request) {
		System.out.println(request.getNumber1());

	
	}


}
