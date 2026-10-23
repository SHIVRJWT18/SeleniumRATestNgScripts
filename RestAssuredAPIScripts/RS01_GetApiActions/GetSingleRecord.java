package RS01_GetApiActions;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class GetSingleRecord {

    @Test
    public void GetSingleUser() {
        given()
        .when()
        .get("https://reqres.in/api/users?page=2")
        .then()
        .statusCode(200)
        .body("page", equalTo(2))
        .log().all();
    }
}