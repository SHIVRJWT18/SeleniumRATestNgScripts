package RS06_ApiRequestChaining.java;

import org.json.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import com.github.javafaker.Faker;

import io.restassured.response.Response;

public class ChainingDemo {

	/**
	 * Website: https://gorest.co.in/
	 * Sign up with gmail and get your bearer token
	 * Api Link: https://gorest.co.in/public/v2
	 * Test flow:
     * Create -> GET -> PUT -> PATCH -> DELETE
	 */	 
	String bearertoken = "c7dab0060f9f7cb5fe57b201ea4220da68d5d67672ca9e3191dc391e8c44904f";
    int uid ;
    String email;
	Faker fak = new Faker();
	JSONObject data = new JSONObject();
	@Test(priority=1)
	public void createRecord()
	{
	 data.put("name",fak.name().fullName());
	 data.put("email", fak.internet().emailAddress());
	 data.put("status", fak.options().option("active", "inactive"));	 
	 data.put("gender", fak.options().option("male", "female"));	
	
	 Response resp = given()
	    .baseUri("https://gorest.co.in/public/v2")
	    .headers("Authorization","Bearer "+bearertoken) // Space is required follwed by Bearer ke
	    .contentType("application/json")
	    .body(data.toString())
	 .when()
	    .post("/users");
	 resp.then()
	     .statusCode(201)
         .log().body();
	 
	 uid  = resp.jsonPath().getInt("id");
	 System.out.println("Created User id: "+uid);	 
	}
	
	@Test(priority = 2, dependsOnMethods = "createRecord")
	public void getRecord()
	{		
	  given()
	    .baseUri("https://gorest.co.in/public/v2")
	    .headers("Authorization","Bearer "+bearertoken)
	    .pathParam("id", uid)		
	  .when()
        .get("/users/{id}")
      .then()
        .statusCode(200)
        .body("id", equalTo(uid))
        .log().body();	
	 }
	
	@Test(priority = 3, dependsOnMethods = "getRecord")
	public void updateRecord()
	{
        data.put("name", fak.name().nameWithMiddle());
        data.put("email","updated" + System.currentTimeMillis()+ "@example.com");               
        data.put("status", "active");
        data.put("gender", "male");

        Response resp =
            given()
    	        .baseUri("https://gorest.co.in/public/v2")
                .header("Authorization", "Bearer " + bearertoken)
                .contentType("application/json")
                .pathParam("id", uid)
                .body(data.toString())
            .when()
                .put("/users/{id}");

        resp.then()
            .statusCode(200)
            .body("id", equalTo(uid))
            .body("status", equalTo("active"))
            .log().body();	
	}
	
	@Test(priority = 4, dependsOnMethods = "updateRecord")
	public void partialUpdateRecord()
	{
        data.put("status", "inactive");
        given()
	        .baseUri("https://gorest.co.in/public/v2")
            .header("Authorization", "Bearer " + bearertoken)
            .contentType("application/json")
            .pathParam("id", uid)
            .body(data.toString())
        .when()
            .patch("/users/{id}")
        .then()
            .statusCode(200)
            .body("id", equalTo(uid))
            .body("status", equalTo("inactive"))
            .log().body();
    }

	
	 @Test(priority = 5, dependsOnMethods = "createRecord")
	public void deleteRecord()
	{
	    given()
	        .baseUri("https://gorest.co.in/public/v2")
            .header("Authorization", "Bearer " + bearertoken)
            .pathParam("id", uid)
        .when()
            .delete("/users/{id}")
        .then()
            .statusCode(204)
            .log().ifError();

        System.out.println("Deleted User ID: " + uid);
    }	
}
