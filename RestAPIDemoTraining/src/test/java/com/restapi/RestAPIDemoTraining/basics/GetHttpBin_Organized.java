package com.restapi.RestAPIDemoTraining.basics;

import io.restassured.RestAssured;

public class GetHttpBin_Organized {
	 public static void main( String[] args )
	    {
	    	
	        
	        RestAssured.baseURI="http://httpbin.org";
	        
	        RestAssured
	        	.given()
	        		.headers("MyHearder1", "Custom Header Value1")
	        		.cookies("MyCookie1", "Custom Cookie value 1")
	        	.when()
	        		.get("/get")
	        	.then()
	        		.extract()
	        		.response()
	        		.prettyPrint();
	        	
	    }
	 

}
