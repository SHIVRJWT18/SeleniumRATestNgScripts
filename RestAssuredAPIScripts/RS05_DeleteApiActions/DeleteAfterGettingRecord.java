package RS05_DeleteApiActions;

import static io.restassured.RestAssured.given;
import java.util.HashMap;
import org.testng.annotations.Test;

public class DeleteAfterGettingRecord {

	int getid ;
	
    @Test(priority =1, enabled = false)
    public void getSingleUser() {
    	getid=   given()
                 .when()
                   .get("https://reqres.in/api/users/11")
                   .jsonPath().getInt("data.id");
       
    }
   
    @Test(priority =2,dependsOnMethods = {"getSingleUser"},enabled = false)
    public void deleteExistingUser()
    {                
        given()
        .when()
          .delete("https://reqres.in/api/users/"+getid)
        .then()
          .statusCode(204)
          .log().all();
    }
}
