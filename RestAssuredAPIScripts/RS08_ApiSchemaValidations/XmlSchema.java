package RS08_ApiSchemaValidations;

import org.hamcrest.Matcher;
import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;

import java.io.File;
public class XmlSchema {

	/* Base Url : https://mocktarget.apigee.net/xml
	 * 
	 * */
	@Test
	public void ValidateSchemaXml()
	{
		given()
       .baseUri("https://mocktarget.apigee.net")
       .contentType("application/xml")
      .when()
       .get("/xml")
      .then()
       .statusCode(200)
       .log().body()
	   .body(RestAssuredMatchers.matchesXsdInClasspath(
			   "RS08_ApiSchemaValidations/XmlResponseSchema.xsd"));
    		   
	} 		   
}
