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
	
	@GetMapping("/")
	public String goHome() {
		return "index";
	}
	
	@GetMapping("/call") 
	public String getTFLinfo(Model model) {
		
		String response = tflService.getTFLdata();
		
		if(!response.contains("Exception")) {
		long id = tflRepository.count() + 1;
		
	    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    Date date = new Date();
		
		TFLInfo tflInfo = new TFLInfo(id, response,dateFormat.format(date));
		tflRepository.insert(tflInfo);
		model.addAttribute("tflInfo", tflInfo);
		
		//System.out.println(tflInfo);
		return "call";
		}
		else {
			model.addAttribute("Exception", response);
			return "error";
		}
	}
	
	@GetMapping("/dbfetch")
	public String getDBfetch(Model model) {
		
		List<TFLInfo> tflList= tflRepository.findAll();
		model.addAttribute("tflList", tflList);
		
		return "dbfetch";
		
	}
}
