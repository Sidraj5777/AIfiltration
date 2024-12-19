package com.vertoz.serviceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vertoz.model.Creative;

public class CreativeParser {

	 public static Creative parseCreative(String json) {
	        ObjectMapper mapper = new ObjectMapper();
	        try {
	            return mapper.readValue(json, Creative.class);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	
	
}
