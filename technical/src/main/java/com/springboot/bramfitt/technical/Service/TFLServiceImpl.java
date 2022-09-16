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
		try {
		result = restTemplate.getForObject("https://api.tfl.gov.uk/StopPoint/490009333W/arrivals", String.class);
		}
		catch(Exception e) {
			System.out.println(e);
			result = e.toString();
		}
		return result;
		
	}
	
	@Override
	public List<TFLInfo> getDBdata(){
		try{
			dbresponse= tflRepository.findAll();
		}
		catch(Exception e) {
			System.out.println(e);
			TFLInfo tflinfo = new TFLInfo(0, e.toString(), null);
			dbresponse.add(0, tflinfo);
		}
		return dbresponse;

	}
}

