package com.springboot.bramfitt.technical.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TFLServiceImpl implements TFLService {

	@Autowired
	public RestTemplate restTemplate;
	public String result;
	
	@Override
	public String getTFLdata() {
		try {
		result = restTemplate.getForObject("https://api.tfl.gov.uk/StopPoint/490009333W/arrivals", String.class);
		}
		catch(Exception e) {
			System.out.println(e);
			result = e.toString();
		}
		return result;
		
	}
}

