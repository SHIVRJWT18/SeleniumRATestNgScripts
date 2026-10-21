package P16_HandleFileActions;


import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class SendKeysFileUpload
{

 public static void main(String[] args) throws InterruptedException, IOException
 {
	    WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.get("https://demoqa.com/upload-download");
		Thread.sleep(5000);
		d.get("https://demoqa.com/upload-download");

		WebElement upload = d.findElement(By.id("uploadFile"));

		upload.sendKeys("C:\\Users\\Dell\\Downloads\\AboutShiv.pdf");

		System.out.println("File uploaded successfully");

		d.close();
 }

}
