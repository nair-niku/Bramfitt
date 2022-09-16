package com.springboot.bramfitt.technical;

public class TFLInfo {

	public long id;
	public String TFLInfo;
	public String date;
	
	public TFLInfo(long id, String TFLInfo, String date) {
		super();
		this.id = id;
		this.TFLInfo = TFLInfo;
		this.date = date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTFLInfo() {
		return TFLInfo;
	}

	public void setTFLInfo(String TFLInfo) {
		this.TFLInfo = TFLInfo;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "TFLInfo [id=" + id + ", TFLInfo=" + TFLInfo + ", date=" + date + "]";
	}
	

	
}
