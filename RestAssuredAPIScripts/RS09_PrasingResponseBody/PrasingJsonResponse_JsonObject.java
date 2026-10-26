package RS09_PrasingResponseBody;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import org.json.JSONObject;

import static io.restassured.RestAssured.*;
public class PrasingJsonResponse_JsonObject {

	
	//Approach 4: (Using JSON Object Class) 
	//https://automationexercise.com/api/getUserDetailByEmail
	@Test 
	public void testFullResponse()
	{
	    Response res = given()
	            .baseUri("https://automationexercise.com/api")
	            .pathParam("mypath", "brandsList")
	            .contentType("application/json")
	        .when()
	            .get("/{mypath}");

	    res.then()
	            .statusCode(200)
	            .log().body();
	
		// JSON Object class is used to parse the response body.
		JSONObject jo = new JSONObject(res.asString());
		String bname;
		int bid;
		
		// printing all the brand names and their ids 
		for(int i=0; i<jo.getJSONArray("brands").length(); i++)
		{
			bname = jo.getJSONArray("brands").getJSONObject(i).getString("brand");
			System.out.println("BrandName: " + bname);
			bid = jo.getJSONArray("brands").getJSONObject(i).getInt("id");
			System.out.println("BrandIds: " + bid);
		}
		
		// checking if the brand name "Polo" is present 
		int count = 0;
		for(int i=0; i<jo.getJSONArray("brands").length(); i++)
		{
		 bname = jo.getJSONArray("brands").getJSONObject(i).getString("brand");
		 if(bname.equals("Polo")) {
			count++; 
			Assert.assertEquals(bname, "Polo");
		}		 
		}
		System.out.println("Polo is present "+count+" in the response body");

  }
}