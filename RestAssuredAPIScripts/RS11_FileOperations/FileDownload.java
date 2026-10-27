package RS11_FileOperations;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileDownload {

	@Test
	public void DownloadFile() throws IOException
	{
     Response rp = given()
         .baseUri("https://httpbin.org")
         .when()
            .get("/image/png");
     
       rp.then()
         .statusCode(200)
         .log().headers()
         .header("Content-Type","image/png");

       // Save downloaded file
       byte[] fileBytes = rp.asByteArray();

       File dwnlodfile = new File("E://SHIV SCRIPTS//TestData/DownloadedImage.png");
       FileOutputStream fos = new FileOutputStream(dwnlodfile);
       fos.write(fileBytes);
      // Validate downloaded file
      assert dwnlodfile.exists();
      assert dwnlodfile.length() > 0;

      System.out.println("File downloaded successfully!");
      System.out.println("File path: " + dwnlodfile.getAbsolutePath());
      System.out.println("File size: " + dwnlodfile.length() + " bytes");
      fos.close();
}
}
