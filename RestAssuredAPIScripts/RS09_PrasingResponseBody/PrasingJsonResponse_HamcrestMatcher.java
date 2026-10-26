package RS09_PrasingResponseBody;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class PrasingJsonResponse_HamcrestMatcher {

	// Approach 1: (UsingHamcrestMatcher) https://reqres.in/api/unknown/3
	@Test
	public void testResponseJson()
	{
		given()
			.baseUri("https://reqres.in/api")
			.contentType("application/json")
		.when()
		    .get("/unknown/3")
		.then()
		    .statusCode(200)
		   // .log().headers();
		    .header("Content-Encoding", "gzip")
		   .log().body()
		   .body("support.sponsored_by", equalTo("PostHog"))
		   .body("data.name", equalTo("true red"));
	}
}
