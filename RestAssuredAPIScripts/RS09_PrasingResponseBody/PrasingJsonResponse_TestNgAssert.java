package RS09_PrasingResponseBody;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class PrasingJsonResponse_TestNgAssert {

		//Approach 2: (Using TestNG Assert) https://reqres.in/api/unknown
		@Test(enabled = false)
		public void testResponseJson()
		{
			Response res = given()
				.baseUri("https://reqres.in/api")
				.contentType("application/json")
			.when()
			    .get("/unknown");
			
			res.then()
			    .statusCode(200);
			
			Assert.assertEquals(res.getStatusCode(), 200);
			Assert.assertEquals(res.header("Content-Type"), "application/json; charset=utf-8");
			Assert.assertEquals(res.body().jsonPath().getString("name"), "fuchsia rose");				

		//Approach 3: (Using JSON Path) https://reqres.in/api/unknown
			
			String name = res.jsonPath().getString("data[0].name");
			Assert.assertEquals(name, "fuchsia rose");
			int year = res.jsonPath().getInt("data[0].year");
			Assert.assertEquals(year, 2001);
	 }
}
