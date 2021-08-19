package com.restapi.RestAPIDemoTraining.basics;

import io.restassured.RestAssured;

public class GetHttpBin_WithParam {
	 public static void main( String[] args )
	    {
	    	//organize the code
	        
	        RestAssured.baseURI="http://httpbin.org/get";
	        RestAssured
	        	.get("/get")
	        	.prettyPrint();
	        
	    }
	 

}
