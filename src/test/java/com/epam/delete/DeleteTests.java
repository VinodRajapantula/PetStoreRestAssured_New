package com.epam.delete;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.testng.annotations.Test;

public class DeleteTests {
	
	@Test
	public void deletePetById(){
		
		
		given().
		header("accept","application/json").		
		pathParam("petId", "12345").			
		when().delete("https://petstore.swagger.io/v2/pet/{petId}").
		then().statusCode(200).log().all();
	}
}
