package com.epam.headers;

import static io.restassured.RestAssured.given;

import java.util.Map;
import java.util.Map.Entry;

import io.restassured.common.mapper.TypeRef;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class GetHeaders {
	
		Logger logger = LogManager.getLogger(this.getClass());
	
		@Test
		public void getPetById(){
			logger.info("GetHeaders started");
			Response response =  given().
					pathParam("petId", "107").			
					when().get("https://petstore.swagger.io/v2/pet/{petId}");
			
			Headers allHeaders = response.getHeaders();
			System.out.println("******Headers******");
			System.out.println("Content-Type:" + response.getHeader("Content-Type"));
			System.out.println("Connection:" + response.getHeader("Connection-Type"));
			System.out.println("Server:" + response.getHeader("Server"));
			System.out.println("************");
			
			Map<String, String> allCookies = response.cookies();
			System.out.println("******cookies******");
			for (Entry<String, String> entry : allCookies.entrySet()){
				System.out.println(entry.getKey() +"---"+ entry.getValue());
			}
			System.out.println("************");
			
			
			logger.info("GetHeaders started");
			
			
		}

}
