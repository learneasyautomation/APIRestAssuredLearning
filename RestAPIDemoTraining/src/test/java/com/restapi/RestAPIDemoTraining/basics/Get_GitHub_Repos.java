package com.restapi.RestAPIDemoTraining.basics;

import io.restassured.RestAssured;

public class Get_GitHub_Repos {
	 public static void main( String[] args )
	    {
	    	
	        
	        RestAssured.baseURI="http://httpbin.org";
	       
	        /*
	         * log method should be called at the end of given() and beginning of Then()
	         */
	        RestAssured
	        	.given()
	        		.param("Company","LTI")
	        		.header("MyHearder1", "Custom Header Value1")
	        		.cookie("MyCookie1", "Custom Cookie value 1")
	        		.log().all()
	        	.when()
	        		.get("/get")
	        	.then()
	        		.log().all()
	        		.assertThat().statusCode(200);
	        	
	    }
	 

}
