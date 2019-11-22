package com.epam.get;

import static io.restassured.RestAssured.given;

import java.io.PrintStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.output.WriterOutputStream;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.common.mapper.TypeRef;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class GetTests {
	public StringWriter requestWriter;
	public PrintStream requestStream;
	
	public StringWriter responseWriter;
	public PrintStream responseStream;
			
	@BeforeSuite
	public void init(){
		requestWriter = new StringWriter();
		requestStream = new PrintStream(new WriterOutputStream(requestWriter));
		
		responseWriter = new StringWriter();
		responseStream = new PrintStream(new WriterOutputStream(responseWriter));
		
		
	}
	
	
	@Test
	public void getPetById(){
		
		requestStream.println("Viniod");
		System.out.println(requestWriter);
		given().
		filter(new RequestLoggingFilter(requestStream)).
		filter(new ResponseLoggingFilter(responseStream)).
		pathParam("petId", "106").			
		when().get("https://petstore.swagger.io/v2/pet/{petId}");
		//.then().statusCode(200).log().all();
		
		System.out.println("************"+requestWriter.toString());
		System.out.println("************"+responseWriter.toString());
	}
	
	// get all available pets list
	//@Test
		public void getPetsByStatus() throws ParseException{
			String response;
			List<String> list = new ArrayList<String>(); 
			/*response = given().
			queryParam("status", "available").			
			when().get("https://petstore.swagger.io/v2/pet/findByStatus").asString();
			
			JsonPath jsonPath =  new JsonPath(response);
			list = jsonPath.getList("status");
			System.out.println("Number of pets:"+ list.size());
			*/
			/*JSONParser jsonParser = new JSONParser();
			Object obj = jsonParser.parse(response);
			JSONArray employeeList = (JSONArray) obj;
	        System.out.println(employeeList.size());*/
			
			List<Map<String, Object>> products = given().
					queryParam("status", "available").			
					when().get("https://petstore.swagger.io/v2/pet/findByStatus").as(new TypeRef<List<Map<String, Object>>>() {});
			
			System.out.println(products.size());
			
		}


		

}
