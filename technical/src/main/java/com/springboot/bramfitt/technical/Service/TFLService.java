package com.springboot.bramfitt.technical.Service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.springboot.bramfitt.technical.TFLInfo;

@Component
public interface TFLService {

	public String getTFLdata();

	public List<TFLInfo> getDBdata();

}
