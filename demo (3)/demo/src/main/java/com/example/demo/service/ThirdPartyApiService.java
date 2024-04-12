package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface ThirdPartyApiService {
	List<Map<String, Object>> getPosts();

	ResponseEntity<String> getSoap(String soapRequest);


}
