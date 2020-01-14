package com.project.weatherrequest.askforweather;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import static org.junit.Assert.assertEquals;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class AskforweatherApplicationTests {

	@Test
	void testConnection(){
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		String resourceURL = "https://www.youtube.com/iframe_api";
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<String> response = restTemplate.exchange(resourceURL,HttpMethod.GET,entity,String.class);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}

	@Test
	void testConnection2(){
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		Map<String, String> params = new HashMap<String, String>();
		params.put("q", "Chelyabinsk");
		params.put("APPID","0ed4593211fe4ba78de5a8a963426ae2");
		String url ="https://api.openweathermap.org/data/2.5/weather?q={q}&APPID={APPID}";
		ResponseEntity<String> response = restTemplate.exchange(url,HttpMethod.GET,entity,String.class,params);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}
}
