package com.restapi.RestAPIDemoTraining.restcountries;

import java.util.ArrayList;
import java.util.Iterator;

import org.hamcrest.Matchers;

import com.sun.xml.bind.v2.schemagen.xmlschema.List;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Get_Country_By_Name {
	 public static void main( String[] args )
	    {
	    	
	        
		 RestAssured.baseURI="https://restcountries.eu";
		 String resourcePath="/rest/v2/name/{name}";
	       
	        Response r= RestAssured
	        .given()
	        	 .pathParam("name", "India")
	        .when()
	        	.get(resourcePath)
	        .then()
	        	.log().all()
	        	.extract().response();
	     
	     String countryName= r.body().jsonPath().getString("[0].name");
	       System.out.println("First country name is:" + countryName);
	       
	       
	       
	       
	       String currency= r.body().jsonPath().getString("[0].currencies[0].name");
	       System.out.println("Currency of " + countryName + "is" + currency);
	       
	       //without using JsonPath
	       String body= r.body().asString();
	       
	       int index=r.body().asString().indexOf("population");
	       String population=body.substring(index+13, index+17);
	       System.out.println("Population of first country is: " + population);
	       
	       
	       RestAssured
	   	        .given()
	   	        	 .pathParam("name", "India")
	   	        .when()
	   	        	.get(resourcePath)
	   	        .then()
	   	        	.log().all()
	   	        	.assertThat().body("[0].currencies[0].name", Matchers.equalToIgnoringCase("United States Dollar"));
	       
	    
	 
	     ArrayList<String> listOfCountries=new ArrayList<String>();
	 for(int i=0;i<100;i++){ 
		 listOfCountries.add(r.body().jsonPath().getString("["+i +"].name"));
		 
	 }
	 
	 //Traversing list through iterator
	 Iterator itr=listOfCountries.iterator(); //getting the iterator
	 
	 while(itr.hasNext()){
		 if(itr.next().equals("India")){
			 System.out.println("India country is found");
		 }
	 }
	 
	}
}
