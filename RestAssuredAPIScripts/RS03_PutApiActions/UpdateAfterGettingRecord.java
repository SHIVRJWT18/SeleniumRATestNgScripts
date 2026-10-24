package RS03_PutApiActions;

import static io.restassured.RestAssured.given;
import java.util.HashMap;
import org.testng.annotations.Test;

public class UpdateAfterGettingRecord {

	int getid ;
	
    @Test(priority =1)
    public void getSingleUser() {
    	getid=   given()
                 .when()
                   .get("https://reqres.in/api/users/2")
                   .jsonPath().getInt("data.id");
       
    }
   
    @Test(priority =2,dependsOnMethods = {"getSingleUser"})
    public void updateExistingUser()
    {
        HashMap<String,String> newhm = new HashMap<String,String>();
        newhm.put("name","Shewta");
        newhm.put("job", "Recuitment");	
                
        given()
          .contentType("application/json")
          .body(newhm)
        .when()
          .patch("https://reqres.in/api/users/"+getid)
        .then()
          .statusCode(200)
          .log().all();
    }
}
