package RS09_PrasingResponseBody;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
public class PrasingXmlResponse_HamcrestMatcher {

	// Approach 1: (UsingHamcrestMatcher) https://mocktarget.apigee.net/xml
	@Test
	public void testResponseSingleXml()
	{
		given()
			.baseUri("https://mocktarget.apigee.net")
			.header("Content-Type", "application/xml; charset=utf-8")
			.log().all()
		.when()
		    .get("/xml")
		.then()
		    .statusCode(200)		  
		   .log().body()
		   .header("Content-Type", "application/xml; charset=utf-8")
		   .body("root.firstName", equalTo("John"))
		   .body("root.city", equalTo("San Jose"))
		   .body("root.state", equalTo("CA"));
	}
	
	// https://gorest.in/public/v2/users.xml
	@Test
	public void testResponseMultipleXml()
	{
	    given()
        .baseUri("https://gorest.in")
        .log().all()
    .when()
        .get("/public/v2/users.xml")
    .then()
        .statusCode(200)
        .log().body()
        .body("users.user[0].name", equalTo("Aarav Sharma"))
        .body("users.user[1].email", equalTo("priya.mehta@example.com"));

	}
}
