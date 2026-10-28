package RS08_ApiSchemaValidations;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;

public class XmlSchema {

	/**Note: Unlike JsonSchemaValidator, there is no separate XmlSchemaValidator class 
	 * in Rest Assured. XML Schema validation is supported through RestAssuredMatchers, 
	 * which provides methods such as matchesXsd() and matchesXsdInClasspath().
	 * Base Url : https://mocktarget.apigee.net/xml
	 */
	
	/*
	 * Xml to Xsd Converter tool: https://www.site24x7.com/tools/xml-to-xsd.html
	 */
	
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
