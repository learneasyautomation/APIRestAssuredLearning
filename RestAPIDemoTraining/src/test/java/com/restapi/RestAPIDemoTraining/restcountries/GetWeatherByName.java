package com.restapi.RestAPIDemoTraining.restcountries;

import java.util.List;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import junit.framework.Assert;

public class GetWeatherByName {
	@BeforeTest
	public void setup(){
		RestAssured.baseURI="https://api.openweathermap.org/";
		
	}
	
	@Test(enabled=false)
	public void testWeatherReturnedForMumbai(){
		int actualResponseCode= getWeatherByCity("Mumbai").getStatusCode();
		
	    System.out.println("Actual response code" + actualResponseCode);
		int expectedResponseCode=200;
		Assert.assertEquals(actualResponseCode, expectedResponseCode);
		
	}
	
	@Test(enabled=false)
	public void testWeatherReturnedForDelhi(){
		int actualResponseCode= getWeatherByCity("New Delhi").getStatusCode();
		
	    System.out.println("Actual response code" + actualResponseCode);
		int expectedResponseCode=200;
		Assert.assertEquals(actualResponseCode, expectedResponseCode);
		
	}
	
	@Test(enabled=false)
	public void getWeatherById(){
		//1. Search using city name

		 //2. Extract ID of that city

		 //3. Search using city ID

		 //4. Verify that weather in Step#1 and Step #3 is same
		
		
		//Step 1: Search using city name
		System.out.println("Response: " + getWeatherByCity("New Delhi").getBody().prettyPrint());
		
		//step 2: Extract ID of that city
		Response r = getWeatherByCity("New Delhi");
		int cityId = r.body().jsonPath().getInt("id");
		System.out.println("ID of City is: " + cityId);
		
		Response res = getWeatherById(cityId);
		
		String step1Weather=r.body().jsonPath().getString("weather[0].main");
		String step3Weather=res.body().jsonPath().getString("weather[0].main");
		Assert.assertEquals(step1Weather, step3Weather);
	}
	
	
	@Test(enabled=true)
	public void getWeatherByLongitudeAndLatitude(){
		
		System.out.println("Response: " + getWeatherByCity("Bengaluru").getBody().prettyPrint());
		
		//step 2: Extract ID of that city
		Response r = getWeatherByCity("Bengaluru");
		Double longitude = r.body().jsonPath().getDouble("coord.lon");
		Double latitude = r.body().jsonPath().getDouble("coord.lat");
		
		Response res2=getWeatherByLongitude(longitude,latitude);
		String cityWeather= res2.getBody().jsonPath().getString("weather[0].main");
		System.out.println("weather: " + cityWeather);
		
		Assert.assertEquals("Light rain", cityWeather);
		
	}
	
	
	public static Response getWeatherByCity(String cityname){
		return RestAssured
		.given()
			.queryParam("q", cityname)
			.queryParam("appid", "730f811451473f1f1f26e98baa310dd2")
		.when()
			.get("/data/2.5/weather")
		.then()
			.extract().response();
	}
	
	
	public static Response getWeatherById(int cityId){
		return RestAssured
		.given()
			.queryParam("id", cityId)
			.queryParam("appid", "730f811451473f1f1f26e98baa310dd2")
		.when()
			.get("/data/2.5/weather")
		.then()
			.extract().response();
	}
	
	
	public static Response getWeatherByLongitude(Double longitude, Double latitude){
		return RestAssured
		.given()
			.queryParam("lat", latitude )
			.queryParam("lon", longitude)
			.queryParam("appid", "730f811451473f1f1f26e98baa310dd2")
		.when()
			.get("/data/2.5/weather")
		.then()
			.extract().response();
	}

}
