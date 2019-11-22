package com.epam.put;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.epam.pojos.Pet;
import com.epam.utility.Helper;

public class PutTests {
	
	@Test
	public void updatePet(){
		
		Pet pet = new Pet();
		pet.setId(106);
		pet.setName("runny");
		pet.setStatus("sold");
		
		String jsonString =  Helper.ConvertJavaObjectToJson(pet);
		
		given().
		header("accept","application/json").
		header("Content-Type","application/json").
		body(jsonString).
		when().put("https://petstore.swagger.io/v2/pet").
		then().statusCode(200).log().all();
		
	}

}
