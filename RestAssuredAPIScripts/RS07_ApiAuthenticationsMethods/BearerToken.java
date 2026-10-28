package RS07_ApiAuthenticationsMethods;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;
public class BearerToken {

	/**
	 * Link: https://gorest.co.in/
	 * Sign up with gmail and get your bearer token
	 * Api Link: https://gorest.co.in/public/v2
	 */	 
	String bearertoken = "c7dab0060f9f7cb5fe57b201ea4220da68d5d67672ca9e3191dc391e8c44904f";

	@Test
	public void testBearerTokenGet()
	{
		
     given()
         .baseUri("https://gorest.co.in/public/v2")
         .header("Authorization", "Bearer " + bearertoken)
         .contentType("application/json")
       .when()
         .get("/users")
       .then()
         .statusCode(200)
         .log().body();
	
	}
	
	 @Test
	 public void testBearerTokenPost() {

	 String requestBody = """
	            {
	                "name": "Test User",
	                "gender": "male",
	                "email": "testuser123456@example.com",
	                "status": "active"
	            }
	            """;

	        given()
	         .baseUri("https://gorest.co.in/public/v2")
	            .header("Authorization", "Bearer " + bearertoken)
	            .contentType("application/json")
	            .body(requestBody)
	        .when()
	            .post("/users")
	        .then()
	            .statusCode(201)
	            .log().body();
	    }

	
}	
