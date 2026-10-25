package RS01_GetApiActions;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.Map;
public class GetCallWithCookiesInfo {

	@Test
	public void getCookiesInfo() {
	  Response rp =  given()
        .baseUri("https://www.google.com/")
        .when()
        .get("/search?q=maven+repository");

   // .then()
     //   .statusCode(200)
       // .log().cookies();
	  	
	 // Get the all the cookies from the response
	  Map<String,String> cookie = rp.getCookies();
	  System.out.println("Cookie Key: " + cookie.keySet());
	  for (String key : cookie.keySet()) {
	  System.out.println("Cookie Key: " + key + " Cookie Value: " + cookie.get(key));
		
	    }
	   }
	
	}



