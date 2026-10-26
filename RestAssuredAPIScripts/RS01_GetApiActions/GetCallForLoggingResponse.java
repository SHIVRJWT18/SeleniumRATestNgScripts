package RS01_GetApiActions;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class GetCallForLoggingResponse {

	// https://automationexercise.com/api/productsList
	@Test
	public void getLogs() {
		given()
			.baseUri("https://automationexercise.com")
			//.log().all() // Prints all data in request
		.when()
		    .get("/api/productsList")
		.then()
		    .statusCode(200)
		   // .log().all();    // Prints all data in response 
		  //  .log().body();   // Prints only body of the response
		   // .log().cookies(); // Prints only cookies of the response
		    .log().headers(); // Prints only headers of the response
		   // .log().status();  // Prints only status of the response
	}
}
