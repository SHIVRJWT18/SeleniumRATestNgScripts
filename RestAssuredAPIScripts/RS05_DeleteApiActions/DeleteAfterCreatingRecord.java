package RS05_DeleteApiActions;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

public class DeleteAfterCreatingRecord {

	int getcreatedid ;
    @Test(priority =1)
    public void createSingleUser() {
    HashMap<String,String> hm = new HashMap<String,String>();
    hm.put("name","Arjun Bhatt");
    hm.put("job", "Software Engineer");
    
    getcreatedid = given()
         .contentType("application/json")
         .body(hm)
        .when()
          .post("https://reqres.in/api/users")
          .jsonPath().getInt("id");
       
    }
   
    @Test(priority =2,dependsOnMethods = {"createSingleUser"})
    public void deleteCreatedUser()
    {
        given()
        .when()
          .delete("https://reqres.in/api/users/"+getcreatedid)
        .then()
          .statusCode(204)
          .log().all();
    }
}
