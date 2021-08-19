package trello.common;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeSuite;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import trello.common.Utilities;
public class Base {
	
	public static RequestSpecification commonspec;
	@BeforeSuite
	public void setUp() throws IOException, Exception{
		commonspec=(RequestSpecification) new RequestSpecBuilder()
				.setBaseUri("https://api.trello.com")
				.setContentType(ContentType.JSON)
				.addQueryParam("key", Utilities.getProperty("trellokey"))
				.addQueryParam("token", Utilities.getProperty("trellotoken"))
				.build();
				
	}

}
