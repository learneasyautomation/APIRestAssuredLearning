package com.restapi.RestAPIDemoTraining.restcountries;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Get_Country_By_Name_And_List_All_Countries {
	public static void main(String[] args) {

		RestAssured.baseURI = "https://restcountries.eu";
		String resourcePath = "/rest/v2/name/{name}";

		Response r = RestAssured.given().pathParam("name", "India").when().get(resourcePath).then().log().all()
				.extract().response();

		/*
		 * getList can be used if you are going to use the array $ symbol is
		 * used to start from root
		 */
		List<String> countries = r.body().jsonPath().getList("$");
		System.out.println("size of coutries " + countries.size());

		List<String> countriesName = r.body().jsonPath().getList("name");
		System.out.println("size of coutries " + countriesName.size());

		/*
		 * JSON is key and vlaue pairs In java, key value pair can represented
		 * as HashMap It is a list of HashMap
		 */

		List<Map<String, ?>> countriesObjects = r.body().jsonPath().getList("$");

		for (Map<String, ?> country : countriesObjects) {
			if (country.get("name").equals("India")) {
				String capitalCity = country.get("capital").toString();
				if (capitalCity.equals("New Delhi")) {
					System.out.println("Test Passed");
				} else {
					System.out.println("Test Failed");
					System.out.println("Expected Capital City to be New Delhi, but got" + country.get("capital"));
				}
			}
		}

	}
}
