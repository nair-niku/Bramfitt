package com.springboot.bramfitt.technical.Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.bramfitt.technical.TFLInfo;
import com.springboot.bramfitt.technical.Repository.TFLRepository;
import com.springboot.bramfitt.technical.Service.TFLService;

@Controller
public class TFLController {
	
	@Autowired
	private TFLService tflService;
	
	@Autowired
	private TFLRepository tflRepository;
	
	
	//Mapping the homepage
	@GetMapping("/")
	public String goHome() {
		return "index"; 					//redirects to index.html
	}
	
	
	//Mapping the call from api button
	@GetMapping("/call") 
	public String getTFLinfo(Model model) {
		
		//put try-catch to catch connection issues for mongoDB repository
		try {
			String response = tflService.getTFLdata();
			
			/*If there is any exception in getting data from API, the response String will contain the Exception message. 
			Hence the if condition searched whether response contains the word Exception. 
			If Exception is not present, it will process normally, else it will load an error page*/
			
			if(!response.contains("Exception")) {
				long id = tflRepository.count() + 1;
				
			    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			    Date date = new Date();
				
				TFLInfo tflInfo = new TFLInfo(id, response,dateFormat.format(date));
				tflRepository.insert(tflInfo);
				model.addAttribute("tflInfo", tflInfo);
				
				return "call";  				//redirects to call.html
			}
			else {
				model.addAttribute("Exception", response);
				return "error";  				//redirects to error.html
			}
		}
		catch(Exception e) {
			model.addAttribute("Exception", e.toString());
			return "error"; 
		}
	}
	
	@GetMapping("/dbfetch")
	public String getDBfetch(Model model) {
		
		//put try-catch to catch connection issues for mongoDB repository
		try {
			
			//If repository has values, then display, else show No historic data available
			if(tflRepository.count()>0) {	
				List<TFLInfo> tflList= tflService.getDBdata();
				
				/*If String doesn't contain exception passed from Service, display data on dashboard
				else show the Exception and redirect to error page*/
				
				if(!tflList.get(0).TFLInfo.contains("Exception")) {
					model.addAttribute("tflList", tflList);
					return "dbfetch";  			//redirects to dbfetch.html
				}
				else {
					model.addAttribute("Exception", tflList.get(0).TFLInfo);
					return "error";  			//redirects to error.html
				}
			}
			else {
				model.addAttribute("dbfetcherror", "No Historic Data Available");
				return "index"; 
			}
		}
		catch(Exception e) {
			model.addAttribute("Exception", e.toString());
			return "error"; 
		}
		
	}
}
