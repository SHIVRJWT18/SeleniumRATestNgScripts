package RS02_PostApiActions;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class ProvideRqstBodyUsingHashMap {

	@Test
	public void createBooking() {
	 Map<String, String> bookingDates = new HashMap<>();
     bookingDates.put("checkin", "2018-01-01");
     bookingDates.put("checkout", "2019-01-01");

     // Request body
     Map<String, Object> data = new HashMap<>();
     data.put("firstname", "Jim");
     data.put("lastname", "Brown");
     data.put("totalprice", 111);
     data.put("depositpaid", true);
     data.put("bookingdates", bookingDates);
     data.put("additionalneeds", "Breakfast");
     
     Response response = given()
             .baseUri("https://restful-booker.herokuapp.com")
             .contentType("application/json")
             .accept("application/json")
             .body(data)
             .log().all()
         .when()
             .post("/booking");
     
     response.then()
       .statusCode(200)
       .body("booking.firstname", equalTo("Jim"))
       .body("booking.totalprice", equalTo(111))
       .body("booking.depositpaid", equalTo(true))
       .body("booking.bookingdates.checkin",equalTo("2018-01-01"))
       .body("booking.additionalneeds", equalTo("Breakfast"));

     System.out.println("Response Body:");
     response.then().log().body();
   }
}