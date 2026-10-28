package RS07_ApiAuthenticationsMethods;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class BasicAuthentications {

	@Test(priority=1)
	public void testUserNamePassword()
	{
	/**
	 * Basic authentication sends credentials using Base64 encoding
	 * URL: https://httpbin.org/basic-auth/user/pass
       - Username: user
       - Password: pass	
	 */
		given() 
          .auth().basic("user", "pass")  // basic
        .when()
          .get("https://httpbin.org/basic-auth/user/pass")
        .then()
          .statusCode(200)
          .log().body();	
	}
	
	@Test(priority=2)
	public void testDigestAuthentication()
	{
	/**
	 * Digest authentication uses a challenge-response mechanism involving a hash.
	 * URL: https://httpbin.org/basic-auth/user/pass
       - Username: user
       - Password: pass	
	 */
		given()
          .auth().digest("user", "pass")  // digest
        .when()
          .get("https://httpbin.org/basic-auth/user/pass")
        .then()
          .statusCode(200)
          .log().body();	
	}
	
	@Test(priority=3)
	public void testPreemptiveAuthentication()
	{
	/**
	 * Preemptive authentication is a request strategy, not a separate authentication protocol. 
	 * Here, it uses Basic Authentication.
	 * URL: https://httpbin.org/basic-auth/user/pass
       - Username: user
       - Password: pass	
	 */
        given()
        .auth().preemptive().basic("user", "pass")
    .when()
        .get("https://httpbin.org/basic-auth/user/pass")
    .then()
        .statusCode(200)
        .body("authenticated", equalTo(true))
        .body("user", equalTo("user"))
        .log().body();	
	}
}
