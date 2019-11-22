package com.epam.utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Helper {
	
	public static ObjectMapper mapper;
	
	public static String ConvertJavaObjectToJson(Object obj){
		mapper = new ObjectMapper();
		String jsonString = "";
		try {
			jsonString = mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return jsonString;
	}

}
