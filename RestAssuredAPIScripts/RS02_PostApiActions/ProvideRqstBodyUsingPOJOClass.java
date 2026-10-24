package RS02_PostApiActions;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;


import io.restassured.response.Response;

public class ProvideRqstBodyUsingPOJOClass {
/**
 * POJO (Plain Old Java Object) classes are used to create request bodies 
 * in a structured and type-safe manner. 
 * It's a Java class that represents the structure of your request body. 
 * It provides better readability, maintainability, and compile-time checking.
 */

class RequestPojoData {

	/* Select all variables and then Click on 
	   Source > Generate Getters and Setters > Sect all variables > Click on Generate
	*/
	
	String firstname;
	String lastname;
	int totalprice;
	boolean depositpaid;
	String additionalneeds;
	String checkin;
	String checkout;
	    
	public String getFirstname() {
	  return firstname;
	} 
			
	public void setFirstname(String firstname) {
	   this.firstname = firstname;
	}

	public String getLastname() {
	  return lastname;
	}

	public void setLastname(String lastname) {
	   this.lastname = lastname;
	}

	public int getTotalprice() {
	  return totalprice;
	}

	public void setTotalprice(int totalprice) {
	   this.totalprice = totalprice;
	}

	public boolean isDepositpaid() {
	  return depositpaid;
	}

	public void setDepositpaid(boolean depositpaid) {
	  this.depositpaid = depositpaid;
	}

	public HashMap<String, String> getBookingdates() {
	    HashMap<String, String> dates = new HashMap<>();
	    dates.put("checkin", checkin);
	    dates.put("checkout", checkout);
	    return dates;
	}
    		    
    public void setBookingdates(String indate, String outdate) {
        this.checkin = indate;
        this.checkout = outdate;
    }

	public String getAdditionalneeds() {
	  return additionalneeds;
	}

	public void setAdditionalneeds(String additionalneeds) {
	  this.additionalneeds = additionalneeds;
	}
		
	}

	@Test
	public void createBookingUsingPOJO() {
		RequestPojoData reqpojo = new RequestPojoData();
		
		reqpojo.setFirstname("Jacob");
		reqpojo.setLastname("Brown");	
		reqpojo.setDepositpaid(true);
		reqpojo.setTotalprice(3056);
		reqpojo.setBookingdates("2018-01-01", "2019-01-01");
		reqpojo.setAdditionalneeds("Lunch");
		
		Response response = given()
				.baseUri("https://restful-booker.herokuapp.com")
				.contentType("application/json")
				.accept("application/json")
				.body(reqpojo)
			.when()
				.post("/booking");

		response.then()
		 .statusCode(200)
		 .body("booking.firstname", equalTo("Jacob"))
		 .body("booking.totalprice", equalTo(3056))
		 .body("booking.depositpaid", equalTo(true))
		 .body("booking.bookingdates.checkin",equalTo("2018-01-01"))
		 .body("booking.additionalneeds", equalTo("Lunch"));

	  System.out.println("Response Body:");
	  response.then().log().body();
	}
	
}
