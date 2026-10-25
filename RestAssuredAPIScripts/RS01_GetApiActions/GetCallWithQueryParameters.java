package RS01_GetApiActions;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

// https://reqres.in/api/users?page=2
public class GetCallWithQueryParameters {

	@Test
	public void ListUserWithQueryPathParam() {
	   given()
		.baseUri("https://reqres.in/api/users")
		.queryParam("page", 2) // Query parameter
	.when()
	    .get() 
	.then()	
		.statusCode(200)
		.log().all();
	}
}