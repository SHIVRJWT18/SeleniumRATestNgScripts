package RS04_PatchApiActions;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

public class PartialUpdateAfterCreatingRecord {

	int getcreatedid ;
    @Test(priority =1)
    
    public void createSingleUser() {
    HashMap<String,String> hm = new HashMap<String,String>();
    hm.put("name","Karan Mehra");
    hm.put("job", "Assistant Manager");
    
    getcreatedid = given()
         .contentType("application/json")
         .body(hm)
        .when()
          .post("https://reqres.in/api/users")
          .jsonPath().getInt("id");
       
    }
   
    @Test(priority =2,dependsOnMethods = {"createSingleUser"})
    public void partialUpdateExistUser()
    {
        HashMap<String,String> newhm = new HashMap<String,String>();
        newhm.put("name","Reeta Nagpal");
                
        given()
          .contentType("application/json")
          .body(newhm)
        .when()
          .put("https://reqres.in/api/users/"+getcreatedid)
        .then()
          .statusCode(200)
          .log().all();
    }
}
