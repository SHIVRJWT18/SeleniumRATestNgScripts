package RS11_FileOperations;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.io.File;
public class FileUpload {

	// Add Pet -https://petstore.swagger.io/#/pet/addPet
	int petid;
	String reqbody = "{"
            + "\"id\": 98765,"
            + "\"category\": {"
            +     "\"id\": 1,"
            +     "\"name\": \"Dogs\""
            + "},"
            + "\"name\": \"Tommy\","
            + "\"photoUrls\": ["
            +     "\"https://example.com/tommy.jpg\""
            + "],"
            + "\"tags\": ["
            +     "{"
            +         "\"id\": 1,"
            +         "\"name\": \"Golden Retriever\""
            +     "}"
            + "],"
            + "\"status\": \"available\""
            + "}"   ;
	
	@Test(priority =1,enabled=false)
	public void getPetid()
	{
	 Response rsp =  given()
	    .baseUri("https://petstore.swagger.io/v2")
	    .contentType(ContentType.JSON)
        .accept(ContentType.JSON)
        .body(reqbody)
      .when()
        .post("/pet");
	 rsp.then()
	    .statusCode(200)
        .contentType(ContentType.JSON);
	 petid = rsp.jsonPath().getInt("id");
	 rsp.prettyPrint();

	 System.out.println("Pet ID: " + petid);
	}
	
	/* Upload Image Endpoint - "https://petstore.swagger.io/pet/{petID}/UploadImage"
	   File Loc - 
	   Link:  https://petstore.swagger.io/#/pet/uploadFile
	*/ 
	@Test(priority =2,dependsOnMethods = "getPetid",enabled=false)
	public void SingleUpload()
	{
	  File imageFile = new File("E:\\SHIV SCRIPTS\\TestData\\SingleUpload.jpeg");		
		Response rp = given()
			.baseUri("https://petstore.swagger.io/v2")
			.pathParam("petId", petid)
		    .multiPart("file", imageFile)
            .multiPart("additionalMetadata","Test image upload")
         .when()
             .post("/pet/{petId}/uploadImage");
		rp.prettyPrint();

        // Validate response
        rp.then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("code", equalTo(200))
                .body("message", containsString(imageFile.getName()));
        System.out.println("Image uploaded successfully!");
        
	}
	
	@Test()
	public void MultipleUpload()
	{
	 File f1 = new File("E:\\SHIV SCRIPTS\\TestData\\Apidata.json");		
	 File f2 = new File("E:\\SHIV SCRIPTS\\TestData\\MultiFileUpload.txt");		
	 File f3 = new File("E:\\SHIV SCRIPTS\\TestData\\BILL_1335.pdf");		
	 Response rpnse = given()
				.baseUri("https://httpbin.org")
			    .multiPart("file1", f1)
			    .multiPart("file2", f2)
			    .multiPart("file3", f3)
	         .when()
	             .post("/post");
	 rpnse.prettyPrint();
	     rpnse.then()
	      .statusCode(200)
          .body("files.file1", notNullValue())
          .body("files.file2", notNullValue())
          .body("files.file3", notNullValue());
	        System.out.println("All three files uploaded successfully!");

	}
	
	@Test
	public void ArrayFileUpload()
	{
	 File fileA = new File("E:/SHIV SCRIPTS/TestData/MultiFileUpload.txt");
     File fileB = new File("E:/SHIV SCRIPTS/TestData/BILL_1335.pdf");

     // Accepting an array of files depends on the API's design.
     File[] f = {fileA, fileB};
     Response rpse = given()
             .baseUri("https://httpbin.org")
             .multiPart("file1", f[0])
             .multiPart("file2", f[1])
         .when()
             .post("/post");

     rpse.prettyPrint();

     rpse.then()
             .statusCode(200)
             .body("files.file1", notNullValue())
             .body("files.file2", notNullValue());

     System.out.println("Both files were uploaded successfully!");
		
	}
	
}
