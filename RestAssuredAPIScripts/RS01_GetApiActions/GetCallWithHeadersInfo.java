package RS01_GetApiActions;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class GetCallWithHeadersInfo {

	@Test
	public void ValidateHeadersInfo() {
		
	    given()
		  .baseUri("https://www.google.com/")
		  .queryParam("q", "maven repository")
		.when()
		  .get("/search")
		.then()
		  .statusCode(200)
		  .headers("Content-Type", "text/html; charset=ISO-8859-1")
	      .headers("Content-Encoding", "gzip")
	      .headers("Server", "gws");
	  }
	
	@Test()
	public void getHeadersInfo() {
		
	    Response rp = given()
		  .baseUri("https://www.google.com/")
		  .queryParam("q", "maven repository")
		.when()
		  .get("/search");
	    
	    rp.then().statusCode(200);
	    
	    // getHeader() - Get the value of a specific header from the response
		String contentType = rp.getHeader("Content-Type"); 
		System.out.println("Content-Type: " + contentType);
		System.out.println("===========================");
	    
	    // getHeaders() - Get the all the headers from the response
        for (Header header : rp.getHeaders().asList()) {
            System.out.println("Header Key: " + header.getName()+ 
            		" | Header Value: " + header.getValue());
        }

	  }
}
