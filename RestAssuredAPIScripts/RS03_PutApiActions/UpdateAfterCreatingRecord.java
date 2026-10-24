package RS03_PutApiActions;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

public class UpdateAfterCreatingRecord {

	int getcreatedid ;
    @Test(priority =1)
    public void createSingleUser() {
    HashMap<String,String> hm = new HashMap<String,String>();
    hm.put("name","Aftab");
    hm.put("job", "Mayor");
    
    getcreatedid = given()
         .contentType("application/json")
         .body(hm)
        .when()
          .post("https://reqres.in/api/users")
          .jsonPath().getInt("id");
       
    }
   
    @Test(priority =2,dependsOnMethods = {"createSingleUser"})
    public void updateCreatedUser()
    {
        HashMap<String,String> newhm = new HashMap<String,String>();
        newhm.put("name","Neetu");
        newhm.put("job", "Music Teacher");	
                
        given()
          .contentType("application/json")
          .body(newhm)
        .when()
          .patch("https://reqres.in/api/users/"+getcreatedid)
        .then()
          .statusCode(200)
          .log().all();
    }
}
