package com.springboot.bramfitt.technical.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springboot.bramfitt.technical.TFLInfo;
import com.springboot.bramfitt.technical.Repository.TFLRepository;

@Service
public class TFLServiceImpl implements TFLService {

	@Autowired
	public RestTemplate restTemplate;
	
	@Autowired
	private TFLRepository tflRepository;
	
	public String result;
	List<TFLInfo> dbresponse = new ArrayList<TFLInfo>();
	
	@Override
	public String getTFLdata() {
		
		/*Put a try-catch here to catch any error while fetching data from API 
		such as incorrect API details*/
		try {
			result = restTemplate.getForObject("https://api.tfl.gov.uk/StopPoint/490009333W/arrivals", String.class);
		}
		catch(Exception e) {
			result = e.toString();
		}
		return result;
		
	}
	
	@Override
	public List<TFLInfo> getDBdata(){
		
		/*Put a try-catch here to catch any error while fetching data from DB 
		such as connection issues or incorrect credentials causing authorization to fail*/
		try{
			dbresponse= tflRepository.findAll();
		}
		catch(Exception e) {
			TFLInfo tflinfo = new TFLInfo(0, e.toString(), null);
			dbresponse.add(0, tflinfo);
			System.out.println(dbresponse);
		}
		return dbresponse;

	}
}

