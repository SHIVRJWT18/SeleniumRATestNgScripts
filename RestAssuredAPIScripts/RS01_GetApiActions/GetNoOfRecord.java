package RS01_GetApiActions;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class GetNoOfRecord {

    @Test
    public void getSingleUser() {
        given()
        .when()
          .get("https://reqres.in/api/users/7")
        .then()
          .statusCode(200)
          .body("data.id", equalTo(7))
          .log().all();
    }

    @Test
    public void getListUser() {
        given()
        .when()
          .get("https://reqres.in/api/users?page=2")
        .then()
          .statusCode(200)
          .body("page", equalTo(2))
          .log().all();
    }
    
}