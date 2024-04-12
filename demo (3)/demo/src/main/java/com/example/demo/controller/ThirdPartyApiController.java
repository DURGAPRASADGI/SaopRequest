package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ThirdPartyApiService;

@RestController
public class ThirdPartyApiController {
	
	@Autowired
	private ThirdPartyApiService apiService;
	
	@GetMapping("/posts")
	public List<Map<String, Object>> getpost(){
		return apiService.getPosts();
	}

	@PostMapping("/soap/add")
	public ResponseEntity<String> getSoap(@RequestBody String soapRequest){
		return apiService.getSoap(soapRequest);
		
	}
}
