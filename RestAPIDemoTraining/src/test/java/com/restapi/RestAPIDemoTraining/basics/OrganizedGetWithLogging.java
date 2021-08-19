package com.restapi.RestAPIDemoTraining.basics;

import io.restassured.RestAssured;

public class OrganizedGetWithLogging {
	 public static void main( String[] args )
	    {
	    	/*\
	    	 * path parameter
	    	 */
	        
	        RestAssured.baseURI="https://api.github.com";
	       
	        RestAssured
	        .given()
	        	.queryParam("sort","pushed")
	        	.pathParam("username", "dqauser1")
	        .when()
	        	.get("/users/{username}/repos")
	        .then()
	        	.log().all()
	        	.assertThat().statusCode(200)
	        	.assertThat().contentType("application/json");
	        
	        	
	        
	       	    }
	 

}
