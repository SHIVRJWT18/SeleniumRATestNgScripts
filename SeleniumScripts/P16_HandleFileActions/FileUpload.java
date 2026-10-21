package P16_HandleFileActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

	public static void main(String[] args) {
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		
		// Single File Upload:		
		d.findElement(By.cssSelector("input#filesToUpload")).sendKeys("E:\\SHIV SCRIPTS\\TestData\\SingleUpload.jpeg");
        String testfile = d.findElement(By.cssSelector("#fileList li")).getText();
        
		if(testfile.equalsIgnoreCase("SingleUpload.jpeg"))
	    System.out.println("File uploaded successfully!");	
		else
		{
		 System.out.println("Upload Failed...");	
		}		
		
		d.navigate().refresh();
		
		// Multiple File Upload:
		String file1 = "E:\\SHIV SCRIPTS\\TestData\\BILL_1335.pdf";
		String file2 = "E:\\SHIV SCRIPTS\\TestData\\SingleUpload.jpeg";
		
		d.findElement(By.cssSelector("input#filesToUpload")).sendKeys(file1+"\n"+file2);
        int uploadsize = d.findElements(By.cssSelector("#fileList li")).size();

        if(uploadsize==2)
        {
        	System.out.println("All files uploaded successfully!");
        }
        else
        {
          System.out.println("Upload failure... ");	
        }	
		//d.close();
	}

}
