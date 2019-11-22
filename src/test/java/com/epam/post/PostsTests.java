package com.epam.post;

import static io.restassured.RestAssured.given;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.StringWriter;

import org.apache.commons.io.output.WriterOutputStream;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.epam.pojos.Pet;
import com.epam.utility.Helper;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

public class PostsTests {
	
	
	
	
	@Test
	public void updatePetById(){
		
		
		/*given().
		header("accept","application/json").
		header("Content-Type","application/x-www-form-urlencoded").
		pathParam("petId", "1012").			
		when().post("https://petstore.swagger.io/v2/pet/{petId}").
		then().statusCode(200).log().all();*/
		
		given().	
		header("accept","application/json").
		pathParam("petId", "107").
		multiPart("name","runnyNew2").
		when().post("https://petstore.swagger.io/v2/pet/{petId}").
		then().statusCode(200).log().all();
	}
	//@Test
	public void createPetById(){
		
		Pet pet = new Pet();
		pet.setId(110);
		pet.setName("runny");
		pet.setStatus("available");
		
		//String jsonString =  Helper.ConvertJavaObjectToJson(pet);
		
		given().
		header("accept","application/json").
		header("Content-Type","application/json").		
		body(pet).
		when().post("https://petstore.swagger.io/v2/pet").
		then().statusCode(200).log().all();

		
	}

}
