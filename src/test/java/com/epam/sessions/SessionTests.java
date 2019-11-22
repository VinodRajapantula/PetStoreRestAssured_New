package com.epam.sessions;

import io.restassured.filter.session.SessionFilter;
import static io.restassured.RestAssured.given;

public class SessionTests {
	
	public void passinSession(){
		
		
		SessionFilter sessionFilter = new SessionFilter();

		 given().
		         auth().form("John", "Doe").
		         filter(sessionFilter).
		 expect().
		          statusCode(200).
		 when().
		        get("/x");

		 given().
		         filter(sessionFilter). // Reuse the same session filter instance to automatically apply the session id from the previous response
		 expect().
		          statusCode(200).
		 when().
		        get("/y");
		
	}

}
