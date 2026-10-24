package RS02_PostApiActions;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.json.JSONObject;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class ProvideRqstBodyUsingOrgJSON {
 
	// Required dependency in pom.xml: JSON	
	int employeeId;
	@Test
	public void createEmployee() {

	JSONObject reqBody = new JSONObject();
	    reqBody.put("firstName","Aditya");
	    reqBody.put("lastName","Bajpai");
	    reqBody.put("department", "QA");
	    reqBody.put("salary","8.69 LPA");
	    
	Response response  = given()
		                   .contentType("application/json")
		                   .body(reqBody.toString())
		                .when()
		                   .post("https://api.qaautomationlabs.com/v1/employees");
    response.then()
		      .statusCode(201)
		      .body("data.firstName", equalTo("Aditya"))
		      .body("data.department", equalTo("QA"))
		      .body("data.salary", equalTo("8.69 LPA"))
		      .header("Content-Type", equalTo("application/json; charset=utf-8"))
		      .log().all();
		
    employeeId = response.jsonPath().getInt("data.id");

    System.out.println("Created Employee ID: " + employeeId);
	}
	
}
