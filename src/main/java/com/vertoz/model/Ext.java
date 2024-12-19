package com.vertoz.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Ext {
	private int gdpr;
    private String us_privacy;
    private int coppa;
	public int getGdpr() {
		return gdpr;
	}
	public void setGdpr(int gdpr) {
		this.gdpr = gdpr;
	}
	public String getUs_privacy() {
		return us_privacy;
	}
	public void setUs_privacy(String us_privacy) {
		this.us_privacy = us_privacy;
	}
	public int getCoppa() {
		return coppa;
	}
	public void setCoppa(int coppa) {
		this.coppa = coppa;
	}
    
    
}
