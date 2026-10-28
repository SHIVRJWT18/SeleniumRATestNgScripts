package RS07_ApiAuthenticationsMethods;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Oauth2 {

	@Test(enabled = false)
	public void testOauth1Authentication_Syntax()
	{
        String consumerKey = "YOUR_CONSUMER_KEY";
        String consumerSecret = "YOUR_CONSUMER_SECRET";
        String accessToken = "YOUR_ACCESS_TOKEN";
        String tokenSecret = "YOUR_TOKEN_SECRET";

        given()
            .auth().oauth(consumerKey,consumerSecret,accessToken,tokenSecret)
        .when()
            .get("YOUR_OAUTH1_PROTECTED_API_URL")
        .then()
            .statusCode(200)
            .log().body();
	}
	
	@Test(enabled = true)
	public void testOauth2Authentication()
	{
      String requestBody = """
                {
                    "username": "emilys",
                    "password": "emilyspass"
                }
                """;
      
      Response loginResponse =
                given()
                    .baseUri("https://dummyjson.com")
                    .contentType("application/json")
                    .body(requestBody)
                .when()
                    .post("/auth/login");
            loginResponse.then()
                .statusCode(200)
                .log().body();

      String accessToken = loginResponse.jsonPath().getString("accessToken");
      System.out.println("YourAccessToken: "+accessToken);

      // Step 2: Access the protected endpoint
             given()
                .baseUri("https://dummyjson.com")
                .auth().oauth2(accessToken)
            .when()
                .get("/auth/me")
            .then()
                .statusCode(200)
                .log().body();
	}	
}
