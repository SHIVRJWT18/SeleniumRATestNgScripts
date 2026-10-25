package RS10_DataParametrization;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.response.Response;


public class ProvideRqstBodyUsingExtrnalJSONFile {

	@Test
	public void createBookingUsingJsonFile() throws FileNotFoundException {
	 File f = new File(new File(System.getProperty("user.dir")).getParent()+"\\TestData\\Apidata.json");	
	 FileReader fr = new FileReader(f);	
	 JSONTokener jt = new JSONTokener(fr);
	 JSONObject data = new JSONObject(jt);	
		
		
		Response response = given()
				.baseUri("https://restful-booker.herokuapp.com")
				.contentType("application/json")
				.accept("application/json")
				.body(data.toString())
			.when()
				.post("/booking");
		
		response.then()
			.statusCode(200)
			.body("booking.firstname", equalTo("Jim"))
			.body("booking.totalprice", equalTo(111))
			.body("booking.depositpaid", equalTo(true))
			.body("booking.bookingdates.checkin", equalTo("2018-01-01"))
			.body("booking.additionalneeds", equalTo("Breakfast"));
		
		System.out.println("Response Body:");
		response.then().log().body();
	}
}
