package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.val;

@Service
public class ThirdPartyApiServiceImplentation implements ThirdPartyApiService {
	
	@Autowired
     private RestTemplate restTemplate;
	
	String soapUri="https://ecs.syr.edu/faculty/fawcett/Handouts/cse775/code/calcWebService/Calc.asmx?op=Add";

	String baseUrl="https://jsonplaceholder.typicode.com/"; 
	StringBuilder builder=new StringBuilder(baseUrl);

	String postextend ="posts";


	@Override
	public List<Map<String, Object>> getPosts() {
		HttpEntity<Void> httpEntity=new HttpEntity<>(getHeaders());

		String uri=builder.append(postextend).toString();

		System.out.println(uri);
		
		return restTemplate.exchange(uri, HttpMethod.GET, httpEntity, List.class).getBody();

		//return restTemplate.exchange (uri, HttpMethod.GET, httpEntity, List.class).getBody();

		}

		private HttpHeaders getHeaders() {

		HttpHeaders httpHeaders=new HttpHeaders();

		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON)); 
		httpHeaders.setContentType (MediaType.APPLICATION_JSON);

		return httpHeaders;

		
	}

		@Override
		public ResponseEntity<String> getSoap(String soapRequest) {
			// TODO Auto-generated method stub
			List<String> list=new ArrayList<>();
			
			 HttpHeaders httpHeaders = new HttpHeaders();
		        httpHeaders.setContentType(MediaType.TEXT_XML); // Adjusted content type
		        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));

		        // Add Content-Type with charset=utf-8
		        //httpHeaders.add("Content-Type", "text/xml; charset=utf-8");
	        

			list.add(soapRequest);
			System.out.println(soapRequest);
			HttpEntity<String> httpEntity=new HttpEntity<>(soapRequest,httpHeaders);
//			val response= restTemplate.exchange(soapUri, HttpMethod.POST, httpEntity, List.class).getBody();
	        ResponseEntity<String> response = restTemplate.exchange(soapUri, HttpMethod.POST, httpEntity, String.class);

			System.out.println(response);

			return response;
		}

		 
}
