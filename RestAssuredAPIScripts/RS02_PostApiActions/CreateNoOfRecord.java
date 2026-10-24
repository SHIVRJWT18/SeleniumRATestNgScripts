package RS02_PostApiActions;

import static io.restassured.RestAssured.given;
import java.util.HashMap;
import org.testng.annotations.Test;

public class CreateNoOfRecord {

    @Test
    public void createSingleUser() {
    HashMap<String,String> hm = new HashMap<String,String>();
    hm.put("name","Soniya");
    hm.put("job", "talyor");
    
        given()
         .contentType("application/json")
         .body(hm)
        .when()
          .post("https://reqres.in/api/users")
        .then()
          .statusCode(201)
          .log().all();
    }
}
