package RS08_ApiSchemaValidations;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;
import static io.restassured.RestAssured.*;
public class JsonSchema {

	/* Convertor tool[Json to Json Schema]: 
	   https://transform.tools/json-to-json-schema
	   
	   Url: https://reqres.in/api/users/5
	*/
	@Test
	public void ValidateSchemaJson()
	{
        given()
          .baseUri("https://reqres.in")
          .contentType("application/json")
          .log().all()
        .when()
          .get("/api/users/5")
        .then()
          .statusCode(200)
          .log().body()
		  .body(JsonSchemaValidator.matchesJsonSchemaInClasspath(
			    "RS08_ApiSchemaValidations/UserSchema.json"));	
		  
	}
	
	
}
