package RS04_PatchApiActions;

import static io.restassured.RestAssured.given;
import java.util.HashMap;
import org.testng.annotations.Test;

public class PartialUpdateAfterGettingRecord {

	int getid ;
	
    @Test(priority =1)
    public void getSingleUser() {
    	getid=   given()
                 .when()
                   .get("https://reqres.in/api/users/8")
                   .jsonPath().getInt("data.id");
       
    }
   
    @Test(priority =2,dependsOnMethods = {"getSingleUser"})
    public void partialUpdateExistUser()
    {
        HashMap<String,String> newhm = new HashMap<String,String>();
        newhm.put("name","Pryagya Dhiman");
                
        given()
          .contentType("application/json")
          .body(newhm)
        .when()
          .put("https://reqres.in/api/users/"+getid)
        .then()
          .statusCode(200)
          .log().all();
    }
}
