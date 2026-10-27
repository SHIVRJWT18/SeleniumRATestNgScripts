package RS09_PrasingResponseBody;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class PrasingXmlResponse_TestNgAssert {

		//Approach 2: (Using TestNG Assert) https://www.w3schools.com/xml/cd_catalog.xml 
		@Test
		public void testResponseJson()
		{
		  Response resp =   given()
	        .baseUri("https://gorest.in")
	        .log().all()
	    .when()
	        .get("/public/v2/users.xml");
	    resp.then()
	        .statusCode(200)
	        .log().body();
			
			Assert.assertEquals(resp.getStatusCode(), 200);
			Assert.assertEquals(resp.header("Content-Type"), "application/xml; charset=utf-8");
			Assert.assertEquals(resp.body().xmlPath().getString("users.user[1].name"), "Priya Mehta");				

		//Approach 3: (Using Xml Path) 
			
			String name = resp.xmlPath().getString("users.user[2].name");
			Assert.assertEquals(name, "Rohan Verma");
			int uid = resp.xmlPath().getInt("users.user[2].id");
			Assert.assertEquals(uid, 1003); 
	 }
}
