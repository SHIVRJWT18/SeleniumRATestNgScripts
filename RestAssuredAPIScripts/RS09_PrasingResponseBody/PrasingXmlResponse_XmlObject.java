package RS09_PrasingResponseBody;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import org.json.JSONObject;

import static io.restassured.RestAssured.*;

import java.util.List;
public class PrasingXmlResponse_XmlObject {

	
	//Approach 4: (Using XML Object Class) 
	//https://www.w3schools.com/xml/cd_catalog.xml 
	@Test 
	public void testFullResponse()
	{
		  Response resp =   given()
			        .baseUri("https://gorest.in")
			        .log().all()
			    .when()
			        .get("/public/v2/users.xml");
			    resp.then()
			        .statusCode(200)
			        .log().body();
	
		// XML Path class is used to parse the response body.
		XmlPath xo = new XmlPath(resp.asString());
        List<String> usrnames = xo.getList("users.user.name");
		Assert.assertEquals(usrnames.size(), 10);
		for(int i=0; i<usrnames.size(); i++)
		{
			System.out.println("UserName: " + usrnames.get(i));
			if(usrnames.get(i).equals("Ravi Kumar")) {
				System.out.println("Ravi Kumar is present in the response body");
			}
		}
		int count = 0;
		List<String> activeusr = xo.getList("users.user.status");
	   for(String status: activeusr)
	   {
		   if(status.equals("active")) {
			   count++;
		   }
		   
	   }
	   System.out.println("Active User Count: "+count+" Out of "+activeusr.size());
  }
}