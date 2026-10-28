package RS07_ApiAuthenticationsMethods;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiKey {

	/**
	 * Link: https://thecatapi.com/signup
	 * Sign up with gmail and get your Api key
	 */
	@Test
    public void testApiKeyInHeader() {

        String apiKey = "live_DKfEeFXvvOXLXl2jG1M9Jw9RMMhclL1puqoQ7ayvfHqgnjx84px1NdUT4vE4wQKJ";

        given()
            .baseUri("https://api.thecatapi.com")
            .header("x-api-key", apiKey)
        .when()
            .get("/v1/images/search")
        .then()
            .statusCode(200)
            .body("size()", greaterThan(0))
            .log().body();
        }
	}
	

