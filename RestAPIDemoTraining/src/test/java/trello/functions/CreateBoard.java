package trello.functions;

import io.restassured.RestAssured;
import trello.common.Base;

public class CreateBoard extends Base{

	public static int createNewBoard(String name) {
		
		int statuscode = RestAssured
			.given()
				.spec(commonspec)
				.queryParam("name", name)
			.when()
				.post("/1/boards/")
			.then()
				.log().all()
				.extract().response().statusCode();
		
		return statuscode;
	}

}
