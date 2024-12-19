package com.vertoz.controller;

import com.vertoz.model.Creative;
import com.vertoz.serviceImpl.CreativeParser;
import com.vertoz.serviceImpl.ProcessWithReko;
import com.vertoz.serviceImpl.RedirectionCheck;

public class Controller {
	
	public Creative ScnnerController(String json) {
		
		CreativeParser crParser = new CreativeParser();
		
		Creative creative = crParser.parseCreative(json);
		
		
		return creative;
	}
	
	public static void RecognizationProcess(String imageUrl) {
		
		ProcessWithReko processreko = new ProcessWithReko();
		
		processreko.processWithRekognition(imageUrl);
		
	}
	
	public static void checkRedirect (String imageUrl) {
		
		RedirectionCheck.checkRedirect(imageUrl);
		
	}

}
