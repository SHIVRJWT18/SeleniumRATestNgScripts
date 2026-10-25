package RS01_GetApiActions;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

// https://reqres.in/api/users?page=2&id=5
public class GetCallWithQueryPathParameters {

	@Test
	public void ListUserWithQueryPathParam() {
	   given()
		.baseUri("https://reqres.in/api")
		.pathParam("mypath1", "api") // Path parameter
		.pathParam("mypath2", "users") 
		.queryParam("page", 2) // Query parameter
		.queryParam("id", 5)
	.when()
	    .get("/{mypath}") // Using path parameter
	.then()	
		.statusCode(200)
		.body("data.id", equalTo(5))
		.log().all();
	}
}